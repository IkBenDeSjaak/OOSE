package han.oose.ooad;

public class Kwadraat implements IDobbelsteenState{
    @Override
    public int handle(Dobbelsteen dobbelsteen) {
        if(dobbelsteen.getAantalOgen() % 2 == 0) {
            return dobbelsteen.getAantalOgen() * dobbelsteen.getAantalOgen();
        } else {
            dobbelsteen.setDobbelsteenState(new Dubbel());
            return dobbelsteen.getAantalOgen() * dobbelsteen.getAantalOgen();
        }
    }
}
