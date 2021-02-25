package oose.dea.resources.exceptionmappers;

import oose.dea.services.exceptions.ItemNotAvailableException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ItemNotAvailableExceptionMapper implements ExceptionMapper<ItemNotAvailableException> {
    @Override
    public Response toResponse(ItemNotAvailableException e) {
        return Response.status(404).build();
    }
}
