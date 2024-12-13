import java.util.Scanner;

public class TCA_AgndCConsulta {
    final static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {

        imprimirMenu();

        utilizarFuncoes();
        // apresentarAgendar();
        // apresentarTutorial();
        // apresentarMenuFuncoes();
        // apresentarTelaDespedida();

    }

    public static void utilizarFuncoes() {
        int comando = 0;
        do {
            comando = lerComandoUsuario();
            String[][] paginasBackup; // [0] = mes , [1] dia , [2] tipo , [3] = log
            switch (comando) {
                case 1:
                    paginasBackup = registrarLogs(paginasBackup);
                    break;
                case 2:
                    consultar(paginasBackup);
                    break;
                case 3:
                    imprimirTutorial();
                    break;
            }

        } while (comando != 0);
    }

    public static int lerComandoUsuario() {
        int comando = 0;
        do {
            comando = lerNumInt();
        } while (comando < 0 || comando > 3);
        return comando;
    }

    public static String[][] registrarLogs(String[][] paginasBackup) {
        int qtdLog = lerNumInt();
        String[][] paginas = criarMatrizString(qtdLog, 4);// [0] = mes , [1] dia , [2] tipo , [3] = log
        paginas = registrar(paginas);
        paginasBackup = salvarRegistro(paginas, paginasBackup);
        return paginasBackup;
    }

    public static String[][] salvarRegistro(String[][] paginas, String[][] paginasBackup) {
        for (int i = 0; i < paginasBackup.length; i++) {
            for (int j = 0; j < 4; j++) {
                paginasBackup[i][j] = paginas[i][j];
            }
        }
        return paginasBackup;
    }

    public static String[][] registrar(String[][] paginas) {

        for (int i = 0; i < paginas.length; i++) {
            paginas[i][0] = lerMes();
            paginas[i][1] = lerDia();
            paginas[i][2] = lerTipo();
            paginas[i][3] = lerRegistro();
        }
        return paginas;
    }

    public static String lerRegistro() {
        String texto = null;
        texto = lerTexto();
        return texto;
    }

    public static String lerTexto() {
        return LER.nextLine();
    }

    public static String integerToString(int numero) {
        String numeroString = null;
        numeroString = String.valueOf(numero);
        return numeroString;
    }

    public static String charToStrg() {
        char v = 'P';
        String as = null;
        as = String.valueOf(v);
        return as;
    }

    public static String lerTipo() {
        char tipo = ' ';
        String tipoString = "";
        while (true) {
            tipo = lerChar();
            if (tipo == 'P') {
                break;
            } else if (tipo == 'E') {
                break;
            }
        }
        tipoString = charToStrg();
        return tipoString;

    }

    public static char lerChar() {
        return LER.next().charAt(0);
    }

    public static String lerDia() {
        int diaEmNumero = 0;

        String dia = "";
        do {
            diaEmNumero = lerNumInt();
        } while (diaEmNumero < 1 || diaEmNumero > 31);

        dia = integerToString(diaEmNumero);
        return dia;
    }

    public static String lerMes() {
        int mesEmNumero = 0;
        String mes = "";
        do {
            mesEmNumero = lerNumInt();
        } while (mesEmNumero < 1 || mesEmNumero > 12);

        mes = integerToString(mesEmNumero);
        return mes;
    }

    public static String[][] criarMatrizString(int linhas, final int colunas) {
        String[][] matrizString = criarMatrizString(linhas, colunas);
        return matrizString;
    }

    public static int lerNumInt() {
        int x = 0;
        do {
            x = LER.nextInt();
        } while (x < 0);
        return x;
    }

    public static boolean verificarComandoParaTutorial() {
        boolean repetir = false;
        int comando = lerNumInt();
        if (comando == 3) {
            repetir = true;
        }
        return repetir;
    }

    public static void imprimirTutorial() {
        final String formato = "MM/DD/TIPO/REGISTRO";
        final String exemplo = "10/31/(P)/Halloween";
        System.out.println();
        System.out.println("____________________________________________________________");
        System.out.println("Como REGISTRAR: ");
        System.out.println("Digite DIAS em NUMEROS INTEIROS");
        System.out.println("Digite MÊS em NUMEROS INTEIROS");
        System.out.println("Digite TIPO em 1 Caractere baseado no significado abaixo: ");
        System.out.println("[P] = Registro PESSOAL");
        System.out.println("[E] = Registro ESTUDANTIL");
        System.out.println("Digite na ordem: " + formato);
        System.out.println("Exemplo: " + exemplo);
        System.out.println("____________________________________________________________");
        System.out.println();

        System.out.println();
        System.out.println("____________________________________________________________");
        System.out.println("Como CONSULTAR: ");
        System.out.println("Digite o mês que deseja consultar");
        System.out.println("Digite em seguida o DIA(S) que deseja consultar");
        System.out.println("Digite um caractere baseado na tabela abaixo: ");
        System.out.println("[1] = Consultar APENAS os REGISTROS do tipo PESSOAL");
        System.out.println("[2] = Consultar APENAS os REGISTROS do tipo ESTUDANTIL");
        System.out.println("[3] = Consultar registros de TODOS OS TIPOS");
        System.out.println("Exemplo: ");

        System.out.println("Mês: 10");
        System.out.println("Dia: 31");
        System.out.println("1");

        System.out.println("____________________RELATORIO____________________");
        System.out.println("No dia 31 do Mês 10 você tem: ");

        System.out.println();

        System.out.println("----------------------------------------------------------");
        System.out.println("1- para REGISTRAR ");
        System.out.println("2- para CONSULTAR REGISTROS");
        System.out.println("3- para ver como operar a agenda");
        System.out.println("0- para encerrar o programa");
        System.out.println("----------------------------------------------------------");

        System.out.println("O que você deseja fazer?");

    }

    public static void imprimirMenu() {

        System.out.println("----------------------------------------------------------");
        System.out.println("_Agenda com consulta_");
        System.out.println("1- para REGISTRAR ");
        System.out.println("2- para CONSULTAR REGISTROS");
        System.out.println("3- para ver como operar a agenda");
        System.out.println("0- para encerrar o programa");
        System.out.println("----------------------------------------------------------");

        System.out.println("O que você deseja fazer?");
    }
 public static void percorrerMatUntillX(String [][] paginas){

     int x =LER.nextInt();

 for (int index = 0; index < x; index++) {

       for (int i = 0; i < paginas.length; i++) {

           for (int j = 0; j < 4; j++) {
               
           }
       }
    }
 }
}
