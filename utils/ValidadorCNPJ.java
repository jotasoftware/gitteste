package utils;

public class ValidadorCNPJ {

    public static boolean isValidCNPJ(String cnpj) {
        // Remove caracteres especiais
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // Verifica tamanho
        if (cnpj.length() != 14) return false;

        // Verifica se todos os dígitos são iguais
        if (cnpj.matches("(\\d)\\1{13}")) return false;

        try {
            int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int soma = 0;
            for (int i = 0; i < 12; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * pesos1[i];
            }
            int dig1 = soma % 11 < 2 ? 0 : 11 - (soma % 11);

            soma = 0;
            for (int i = 0; i < 13; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * pesos2[i];
            }
            int dig2 = soma % 11 < 2 ? 0 : 11 - (soma % 11);
    

            return cnpj.charAt(12) == Character.forDigit(dig1, 10) &&
                   cnpj.charAt(13) == Character.forDigit(dig2, 10);
        } catch (Exception e) {

            return false;

        }
    }
}