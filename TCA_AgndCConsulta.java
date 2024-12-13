import java.util.Scanner;

public class TCA_AgndCConsulta {
    final static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        imprimirMenu();

        utilizarFuncoes();

    }

    public static void utilizarFuncoes() throws InterruptedException {
        int comando = 0;
        String[][] paginasBackup = criarMatrizString(372, 4); // QTD MAXIMA DE REGISTROS colunas: [0] = mes , [1] dia ,
                                                              // [2] tipo , [3] = log

        do {

            comando = lerComandoUsuario();
            switch (comando) {
                case 1:
                    System.out.println("Registrando...");
                    Thread.sleep(1500);
                    paginasBackup = registrarLogs(paginasBackup);
                    break;
                case 2:
                    consultar(paginasBackup);
                    break;
                case 3:
                    imprimirTutorial();
                    break;
                case 4:
                    imprimirMenu();
                    break;
            }

        } while (comando != 0);

    }

    public static void consultar(String[][] paginasBkp) {
        String mes = null;
        String dia = null;
        String tipo = null;
        boolean definirTipo = false;

        mes = lerMes();
        dia = lerDia();
        definirTipo = obterUmTipo();
        if (definirTipo) {
            tipo = lerTipo();
            imprimirComOTipo(paginasBkp, mes, dia, tipo);
        } else {
            imprimirRegistroDiaMes(paginasBkp, mes, dia);

    }
}

    public static String findDayName(String dia) {
        String dayName = null;
        int dayInt = convetSringToInt(dia);
        if (dayInt == 1 || dayInt == 8 || dayInt == 15 || dayInt == 22 || dayInt == 29) {
            dayName = "Domingo";
        } else if (dayInt == 2 || dayInt == 9 || dayInt == 16 || dayInt == 23 || dayInt == 30) {
            dayName = "Segunda";
        } else if (dayInt == 3 || dayInt == 10 || dayInt == 17 || dayInt == 24 || dayInt == 31) {
            dayName = "Terça";
        } else if (dayInt == 4 || dayInt == 11 || dayInt == 18 || dayInt == 25) {
            dayName = "Quarta";
        } else if (dayInt == 5 || dayInt == 12 || dayInt == 19 || dayInt == 26) {
            dayName = "Quinta";
        } else if (dayInt == 6 || dayInt == 13 || dayInt == 20 || dayInt == 27) {
            dayName = "Sexta";
        } else {
            dayName = "Sabado";
        }
        return dayName;
    }

    public static boolean obterUmTipo() {
        boolean definirSeHáUmTipo = false;
        int comando = 0;
        System.out.println("Deseja definir imprimir apenas logs de um tipo especifico?");
        System.out.println("1 - sim | 2- não");
        comando = lerComandoDefinidor();
        if (comando == 1) {
            definirSeHáUmTipo = true;
        }
        return definirSeHáUmTipo;

    }

    public static int lerComandoDefinidor() {
        int comando = 0;
        do {
            comando = lerNumInt();
        } while (comando < 1 || comando > 2);
        return comando;
    }

    public static void imprimirComOTipo(String[][] paginasBkp, String mes, String dia, String tipo) {

        String qualMes = encontrarNomeMes(mes);
        String tipoAtv = nomearTipo(tipo);
        String qualDia = findDayName(dia);

        for (int i = 0; i < paginasBkp.length; i++) {
            if (mes.equals(paginasBkp[i][0])) {
                if (dia.equals(paginasBkp[i][1])) {
                    if (tipo.equals(paginasBkp[i][2])) {
                        System.out.println("=====================================================================");
                        System.out.printf("No mês: %s - %s\n No dia %s - %s\n Do tipo %s\n Você registrou: ", mes,
                                qualMes, dia, qualDia, tipoAtv);
                        System.out.println(paginasBkp[i][3]);
                        System.out.println("=====================================================================");
                    }
                }
            }
        }
    }

    public static String nomearTipo(String tipo) {
        String tipoName = null;
        if (tipo.equals("P") || tipo.equals("p")) {
            tipoName = "Pessoal";
        } else {
            tipoName = "Estudantil";
        }
        return tipoName;
    }

    public static void imprimirRegistroDiaMes(String[][] paginasBkp, String mes, String dia) {

        String qualMes = encontrarNomeMes(mes);
        String qualDia = findDayName(dia);

        for (int i = 0; i < paginasBkp.length; i++) {
            if (mes.equals(paginasBkp[i][0])) {
                if (dia.equals(paginasBkp[i][1])) {
                    System.out.println("=====================================================================");
                    System.out.printf("No mês: %s - %s\n No dia %s - %s\n Você registrou: ", mes, qualMes, dia,
                            qualDia);
                    System.out.println(paginasBkp[i][3]);
                    System.out.println("=====================================================================");

                }
            }
        }
    }

    public static int convetSringToInt(String numString) {
        int numInt = 0;
        numInt = Integer.parseInt(numString);
        return numInt;
    }

    public static String encontrarNomeMes(String mes) {
        final String[] meses = { "mestre ODA!", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro" };
        String mesName = null;
        int mesNum = convetSringToInt(mes);

        for (int i = 1; i < meses.length; i++) {
            if (mesNum == i) {
                mesName = meses[i];
            }
        }
        return mesName;
    }

    public static int lerComandoUsuario() {
        int comando = 0;
        do {
            comando = lerNumInt();
        } while (comando < 0 || comando > 3);
        return comando;
    }

    public static String[][] registrarLogs(String[][] paginasBackup) {
        System.out.print("Insira quantidade de registros desejada: ");
        int qtdLog = lerNumInt();
        String[][] paginas = criarMatrizString(qtdLog, 4);// [0] = mes , [1] dia , [2] tipo , [3] = log
        paginas = registrar(paginas);
        paginasBackup = salvarRegistro(paginas, paginasBackup);
        return paginasBackup;
    }

    public static String[][] salvarRegistro(String[][] paginas, String[][] paginasBackup) {
        for (int i = 0; i < paginas.length; i++) {
            for (int j = 0; j < 4; j++) {
                paginasBackup[i][j] = paginas[i][j];
            }
        }
        return paginasBackup;
    }

    public static String[][] registrar(String[][] paginas) {

        for (int i = 0; i < paginas.length; i++) {

            System.out.print("Insira o mes do " + (i + 1) + "º registro: ");
            paginas[i][0] = lerMes();
            System.out.print("Insira o dia do " + (i + 1) + "º registro: ");
            paginas[i][1] = lerDia();
            System.out.print("Insira o tipo do " + (i + 1) + "º registro: ");
            paginas[i][2] = lerTipo();
            System.out.print("Insira o seu " + (i + 1) + "º registro: ");
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
        String texto = null;
        texto = LER.nextLine();
        return texto;

    }

    public static String integerToString(int numero) {
        String numeroString = null;
        numeroString = String.valueOf(numero);
        return numeroString;
    }

    public static String charToStrg(char tipo) {
        char v = tipo;
        String tipoConvertido = null;
        tipoConvertido = String.valueOf(v);
        return tipoConvertido;
    }

    public static String lerTipo() {
        char tipo = ' ';
        String tipoString = null;
        while (true) {
            tipo = lerChar();
            if (tipo == 'P' || tipo == 'p') {
                break;
            } else if (tipo == 'E' || tipo == 'e') {
                break;
            }
        }
        tipoString = charToStrg(tipo);
        return tipoString;

    }

    public static char lerChar() {
        char characther = ' ';
        characther = LER.next().charAt(0);
        LER.nextLine();
        return characther;
    }

    public static String lerDia() {
        int diaEmNumero = 0;

        String dia = null;
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
        String[][] matrizString = new String[linhas][colunas];
        return matrizString;
    }

    public static int lerNumInt() {
        int x = 0;
        do {
            x = LER.nextInt();
            LER.nextLine();
        } while (x < 0);
        return x;
    }

    public static void imprimirTutorial() {

        System.out.println("----------------------------------------------------------");
        System.out.println(" TUTORIAL: Agenda com Consulta ");
        System.out.println("----------------------------------------------------------");
        System.out.println("Bem-vindo à Agenda com Consulta! Aqui estão as instruções:");
        System.out.println();
        System.out.println("1. MENU PRINCIPAL:");
        System.out.println(" - Escolha uma das opções disponíveis:");
        System.out.println(" 1 - Registrar novos logs");
        System.out.println(" 2 - Consultar registros existentes");
        System.out.println(" 3 - Ver este tutorial novamente");
        System.out.println(" 4 - Reimprimir o menu principal");
        System.out.println(" 0 - Encerrar o programa");
        System.out.println();
        System.out.println("2. COMO REGISTRAR LOGS:");
        System.out.println(" - Escolha a opção 1 no menu.");
        System.out.println(" - Informe a quantidade de registros que deseja adicionar.");
        System.out.println(" - Para cada registro, insira:");
        System.out.println(" > Mês: Número entre 1 e 12.");
        System.out.println(" > Dia: Número entre 1 e 31.");
        System.out.println(" > Tipo: 'P' (Pessoal) ou 'E' (Estudantil).");
        System.out.println(" > Log: Descrição do registro.");
        System.out.println();
        System.out.println("3. COMO CONSULTAR REGISTROS:");
        System.out.println(" - Escolha a opção 2 no menu.");
        System.out.println(" - Informe:");
        System.out.println(" > Mês: Número correspondente ao mês.");
        System.out.println(" > Dia: Número do dia.");
        System.out.println(" - Escolha se deseja filtrar por tipo ('P' ou 'E').");
        System.out.println(" - O programa exibirá os registros correspondentes.");
        System.out.println();
        System.out.println("4. COMO REIMPRIMIR O MENU:");
        System.out.println(" - Escolha a opção 4 para exibir o menu novamente.");
        System.out.println();
        System.out.println("5. COMO ENCERRAR O PROGRAMA:");
        System.out.println(" - Escolha a opção 0 para sair.");
        System.out.println();
        System.out.println("6. EXEMPLO:");
        System.out.println(" - Registro:");
        System.out.println(" > Mês: 10 | Dia: 31 | Tipo: P | Log: \"Halloween\"");
        System.out.println(" - Consulta:");
        System.out.println(" Resultado: \"No mês 10 - Outubro, no dia 31 - Terça, do tipo Pessoal: Halloween.\"");
        System.out.println("----------------------------------------------------------");

        System.out.println("O que você deseja fazer?");
    }

    public static void imprimirMenu() {

        System.out.println("----------------------------------------------------------");
        System.out.println("Agenda com consulta");
        System.out.println("1- para REGISTRAR ");
        System.out.println("2- para CONSULTAR REGISTROS");
        System.out.println("3- para ver como operar a agenda");
        System.out.println("4- para imprimir o MENU novamente");
        System.out.println("0- para encerrar o programa");
        System.out.println("----------------------------------------------------------");

        System.out.println("O que você deseja fazer?");
    }
    public static void printMonth(String[][]paginasBkp,String mes,String dia){
        String qualMes = encontrarNomeMes(mes);
        
        for (int i = 0; i < paginasBkp.length; i++) {
            if (mes.equals(paginasBkp[i][0])) {
                
                        System.out.println("=====================================================================");
                        System.out.printf("No mês: %s - %s\n No dia %s - %s\n Você registrou: ", paginasBkp[i][0],qualMes, paginasBkp[i][1], qualDia);
                        System.out.println(paginasBkp[i][3]);
                        System.out.println("=====================================================================");
            }
        }
     }

    public static void printYear(String[][]paginasBkp){
        for (int i = 0; i < paginasBkp.length-10; i++) {
        String qualMes = encontrarNomeMes(paginasBkp[i][0]);
        String qualDia = findDayName(paginasBkp[i][1]);
               
        System.out.println("=====================================================================");
        System.out.printf("No mês: %s - %s\n No dia %s - %s\n Do tipo %s\n Você registrou: ", paginasBkp[i][0],qualMes, paginasBkp[i][1], qualDia);
        System.out.println(paginasBkp[i][3]);
        System.out.println("=====================================================================");        
                }
            }
        }
