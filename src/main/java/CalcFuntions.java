public class CalcFuntions {

    enum Tipo{SIN,COS,TAN}

    static Tipo tipoFuncion = Tipo.COS;

    public static Double calculate(Double input){
        Double resp = 0.0;
        switch (tipoFuncion){
            case COS:
                resp = calcularCos(input);
                break;
            case SIN:
                resp = calcularSin(input);
                break;
            case TAN:
                resp = calcularTan(input);
                break;
        }
        return resp;
    }

    public static Double calcularCos(Double data){
        return Math.cos(data);
    }

    public static Double calcularSin(Double data){
        return Math.sin(data);
    }

    public static Double calcularTan(Double data){
        return Math.tan(data);
    }

}
