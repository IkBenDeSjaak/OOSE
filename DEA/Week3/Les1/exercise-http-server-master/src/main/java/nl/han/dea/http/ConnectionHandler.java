package nl.han.dea.http;

import nl.han.dea.http.exceptions.TargetNotFoundException;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class ConnectionHandler implements Runnable {

    private static final String CONTENT_LENGTH = "CONTENT_LENGTH";
    private static final String DATE = "DATE_PLACEHOLDER";
    private static final String HTTP_STATUS = "HTTP_STATUS";

    private static final String HTTP_STATUS_200 = "200 OK";
    private static final String HTTP_STATUS_404 = "404 NOT FOUND";

    private HtmlPageReader htmlPageReader = new HtmlPageReader();

    private Socket socket;

    private static final String HTTP_HEADER = "HTTP/1.1 " + HTTP_STATUS + "\n" +
            "Date: " + DATE + "\n" +
            "HttpServer: Simple DEA Webserver\n" +
            "Content-Length: " + CONTENT_LENGTH + "\n" +
            "Content-Type: text/html\n";

//    private static final String HTTP_BODY = "<!DOCTYPE html>\n" +
//            "<html lang=\"en\">\n" +
//            "<head>\n" +
//            "<meta charset=\"UTF-8\">\n" +
//            "<title>Simple Http Server</title>\n" +
//            "</head>\n" +
//            "<body>\n" +
//            "<h1>Hi DEA folks!</h1>\n" +
//            "<p>This is a simple line in html.</p>\n" +
//            "</body>\n" +
//            "</html>\n" +
//            "\n";

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
        handle();
    }

    public void handle() {
        try {
            var inputStreamReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));
            var outputStreamWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.US_ASCII));

            var startLine = parseRequest(inputStreamReader);

            if (startLine == null) { // Prevent a null value from creating a NullPointerException
                return;
            }
            System.out.println(startLine);
            System.out.println(startLine);

            var resource = startLine.split(" ")[1];

            writeResponse(outputStreamWriter, resource);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String parseRequest(BufferedReader inputStreamReader) throws IOException {
        var request = inputStreamReader.readLine();
        var startLine = request;

        while (request != null && !request.isEmpty()) {
            System.out.println(request);
            request = inputStreamReader.readLine();
        }

        return startLine;
    }

    private void writeResponse(BufferedWriter outputStreamWriter, String resource) {
        System.out.println("Writing response for resource: " + resource);

        try {
            writeHeader(outputStreamWriter, resource);
            writeBody(outputStreamWriter, resource);
            outputStreamWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeHeader(BufferedWriter outputStreamWriter, String resource) throws IOException {
        outputStreamWriter.write(generateHeader(resource));
        outputStreamWriter.newLine();
    }

    private void writeBody(BufferedWriter outputStreamWriter, String resource) throws IOException {
        var targetFile = "";

        try {
            targetFile = new HtmlPageReader().readFile(resource);
        } catch (TargetNotFoundException e) {
            System.out.println(e.getMessage());
        }

        outputStreamWriter.write(targetFile);
        outputStreamWriter.newLine();
    }

    private String generateHeader(String resource) {
        var length = "0";
        var status = HTTP_STATUS_200;

        try {
            length = htmlPageReader.getLength(resource);
        } catch (TargetNotFoundException e) {
            status = HTTP_STATUS_404;
        }

        return HTTP_HEADER
                .replace(CONTENT_LENGTH, length)
                .replace(DATE, getServerTime())
                .replace(HTTP_STATUS, status);
    }

    String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }


    @Override
    public void run() {
        handle();
    }
}
