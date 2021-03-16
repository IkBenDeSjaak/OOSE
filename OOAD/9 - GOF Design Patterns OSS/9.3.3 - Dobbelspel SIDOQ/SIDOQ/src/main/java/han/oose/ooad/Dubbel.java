package han.oose.ooad;

public class Dubbel implements IDobbelsteenState{
    @Override
    public int handle(Dobbelsteen dobbelsteen) {
        if(dobbelsteen.getAantalOgen() % 2 == 0) {
            dobbelsteen.setDobbelsteenState(new Kwadraat());
            return dobbelsteen.getAantalOgen() + dobbelsteen.getAantalOgen();
        } else {
            dobbelsteen.setDobbelsteenState(new Enkel());
            return dobbelsteen.getAantalOgen() + dobbelsteen.getAantalOgen();
        }
    }
}
