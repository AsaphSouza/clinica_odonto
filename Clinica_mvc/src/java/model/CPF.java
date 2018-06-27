package model;

import java.util.ArrayList;

public class CPF {

    public boolean validarCpf(String cpf) {
        ArrayList<Integer> array = new ArrayList<>();
        int verificador1 = 0;
        int verificador2 = 0;
        String cpfSaida = "";

        for (int i = 0; i < 9; i++) {
            array.add(Integer.parseInt(cpf.substring(i, i + 1)));
        }

        for (int i = 10; i >= 2; i--) {
            verificador1 += array.get(10 - i) * i;
        }

        if ((verificador1 % 11) < 2) {
            verificador1 = 0;
        } else {
            verificador1 = 11 - (verificador1 % 11);
        }

        array.add(verificador1);

        for (int i = 11; i >= 2; i--) {
            verificador2 += array.get(11 - i) * i;
        }

        if ((verificador2 % 11) < 2) {
            verificador2 = 0;
        } else {
            verificador2 = 11 - (verificador2 % 11);
        }

        array.add(verificador2);

        for (int i = 0; i < array.size(); i++) {
            cpfSaida += array.get(i) + "";
        }

        return cpf.equals(cpfSaida);
    }
    
}
