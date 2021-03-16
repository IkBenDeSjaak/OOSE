package han.oose.ooad;

public class Enkel implements IDobbelsteenState{
    @Override
    public int handle(Dobbelsteen dobbelsteen) {
        if(dobbelsteen.getAantalOgen() % 2 == 0) {
            dobbelsteen.setDobbelsteenState(new Dubbel());
            return dobbelsteen.getAantalOgen();
        } else {
            return dobbelsteen.getAantalOgen();
        }
    }
}
