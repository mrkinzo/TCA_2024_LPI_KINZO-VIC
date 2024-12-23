import java.util.Scanner;

public class AgendaComConsulta {
    final static Scanner LER = new Scanner(System.in);

    static String[][] paginasBackup = criarMatrizString(372, 4);

    // QTD MAXIMA DE REGISTROS colunas: [0] = mes , [1] dia ,
    // [2] tipo , [3] = log
    public static void main(String[] args) throws InterruptedException {

        imprimirMenu();

        utilizarFuncoes();

    }

    public static void utilizarFuncoes() throws InterruptedException {
        int comando = 0;
        do {
            System.out.print("Digite o comando: ");
            comando = lerComandoUsuario();
            switch (comando) {
                case 1:
                    System.out.println("Registrando...");
                    Thread.sleep(1500);
                    paginasBackup = registrarLogs(paginasBackup);
                    break;
                case 2:
                    System.out.println("Obtendo dados...");
                    Thread.sleep(1500);
                    consultar(paginasBackup);
                    break;
                case 3:
                    System.out.println("Abrindo o tutorial...");
                    Thread.sleep(1000);
                    imprimirTutorial();
                    break;
                case 4:
                    System.out.println("Obtendo menu...");
                    Thread.sleep(1000);
                    imprimirMenu();
            }

        } while (comando != 0);

    }

    public static void consultar(String[][] paginasBkp) throws InterruptedException {
        String mes = null;
        String dia = null;
        String tipo = null;

        imprimirMenuConsulta();
        int comando = lerComandoConsulta();

        switch (comando) {
            case 1:
                printYear(paginasBkp);
                break;
            case 2:
                System.out.print("Digite um mês: ");
                mes = lerMes();
                printMonth(paginasBkp, mes);
                break;
            case 3:
                System.out.print("Digite um mês: ");
                mes = lerMes();
                System.out.print("Digite um dia: ");
                dia = lerDia();
                imprimirMesEDia(paginasBkp, mes, dia);
                break;
            case 4:
                System.out.print("Digite um mês: ");
                mes = lerMes();
                System.out.print("Digite um dia: ");
                dia = lerDia();
                System.out.print("Digite um tipo(seu filtro): ");
                tipo = lerTipo();
                imprimirMesEDiaComTipo(paginasBkp, mes, dia, tipo);
                break;
            case 5:
                System.out.print("Digite um mês: ");
                mes = lerMes();
                System.out.print("Digite um tipo(seu filtro): ");
                tipo = lerTipo();
                printMonthPlusType(paginasBkp, mes, tipo);
                break;
            case 6:
                System.out.println("pelos games do ano, pelo mestre tutututuruuuuututututuruuuuu, e pelo SENHOR LOZÃO");
                Thread.sleep(1000);
                for (int i = 0; i < 80; i++) {
                    Thread.sleep(500);
                     printReference();
                }
                break;
        }
    }

    public static void imprimirMenuConsulta() {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.println("[1] - Relatar os registros de um ano inteiro sem filtros;");
        System.out.println("[2] - Relatar os registros de um mes inteiro sem filtros;");
        System.out.println("[3] - Relatar os registros de um mes e um dia sem filtros");
        System.out.println("[4] - Relatar os registros de um mes e um dia com filtro");
        System.out.println("[5] - Relatar um mes inteiro com filtros;");
        System.out.println("[6] - para.....");
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println();

    }

    public static int lerComandoConsulta() {
        int comando = 0;
        do {
            System.out.print("Insira seu comando: ");
            comando = lerNumInt();
        } while (comando < 1 || comando > 6);
        return comando;
    }

    public static void imprimirMesEDia(String[][] paginasBkp, String mes, String dia) {

        String qualMes = encontrarNomeMes(mes);
        String qualDia = findDayName(dia);

        for (int i = 0; i < paginasBkp.length; i++) {
            if (paginasBkp[i][3] != null) {
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
    }

    public static void imprimirMesEDiaComTipo(String[][] paginasBkp, String mes, String dia, String tipo) {

        String qualMes = encontrarNomeMes(mes);
        String tipoAtv = nomearTipo(tipo);
        String qualDia = findDayName(dia);

        for (int i = 0; i < paginasBkp.length; i++) {
            if (paginasBkp[i][3] != null) {
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
    }

    public static void printMonthPlusType(String[][] paginasBkp, String mes, String tipo) {

        String qualMes = encontrarNomeMes(mes);
        String qualTipo = nomearTipo(tipo);

        for (int i = 0; i < paginasBkp.length; i++) {
            if (paginasBkp[i][3] != null) {
                if (mes.equals(paginasBkp[i][0])) {
                    if (tipo.equals(paginasBkp[i][2])) {
                        String qualDia = findDayName(paginasBkp[i][1]);

                        System.out.println("=====================================================================");
                        System.out.printf(" No mês: %s - %s\n No dia %s - %s\n Você registrou: ", paginasBkp[i][0],
                                qualMes,
                                paginasBkp[i][1], qualDia, qualTipo);
                        System.out.println(paginasBkp[i][3]);
                        System.out.println("=====================================================================");
                    }
                }
            }
        }
    }

    public static void printMonth(String[][] paginasBkp, String mes) {
        String qualMes = encontrarNomeMes(mes);

        for (int i = 0; i < paginasBkp.length; i++) {
            if (paginasBkp[i][3] != null) {
                if (mes.equals(paginasBkp[i][0])) {

                    String qualDia = findDayName(paginasBkp[i][1]);
                    String qualTipo = nomearTipo(paginasBkp[i][2]);

                    System.out.println("=====================================================================");
                    System.out.printf(" No mês: %s - %s\n No dia %s - %s\nDo tipo %s\nVocê registrou: ",
                            paginasBkp[i][0],
                            qualMes, paginasBkp[i][1], qualDia, qualTipo);
                    System.out.println(paginasBkp[i][3]);
                    System.out.println("=====================================================================");
                }
            }
        }
    }

    public static void printYear(String[][] paginasBkp) {
        for (int i = 0; i < paginasBkp.length - 10; i++) {
            if (paginasBkp[i][3] != null) {
                String qualMes = encontrarNomeMes(paginasBkp[i][0]);
                String qualDia = findDayName(paginasBkp[i][1]);
                String qualTipo = nomearTipo(paginasBkp[i][2]);

                System.out.println("=====================================================================");
                System.out.printf(" No mês: %s - %s\n No dia %s - %s\n Do tipo %s\n Você registrou: ", paginasBkp[i][0],
                        qualMes, paginasBkp[i][1], qualDia, qualTipo);
                System.out.println(paginasBkp[i][3]);
                System.out.println("=====================================================================");
            } else {
                paginasBkp[i][3] = null;
            }

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

    public static String nomearTipo(String tipo) {
        String tipoName = null;
        if (tipo.equals("P") || tipo.equals("p")) {
            tipoName = "Pessoal";
        } else {
            tipoName = "Estudantil";
        }
        return tipoName;
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
        } while (comando < 0 || comando > 4);
        return comando;
    }

    public static String[][] registrarLogs(String[][] paginasBackup) {
        System.out.print("Insira a quantidade de registros: ");
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

    public static void imprimirTutorial() throws InterruptedException {

        System.out.println("----------------------------------------------------------");
        System.out.println(" TUTORIAL: Agenda com Consulta ");
        System.out.println("----------------------------------------------------------");
        System.out.println("Bem-vindo à Agenda com Consulta! Aqui estão as instruções:");
        Thread.sleep(1000);
        System.out.println();
        System.out.println("1. MENU PRINCIPAL:");
        System.out.println(" - Escolha uma das opções disponíveis:");
        System.out.println(" 1 - Registrar novos logs");
        System.out.println(" 2 - Consultar registros existentes");
        System.out.println(" 3 - Ver este tutorial novamente");
        System.out.println(" 4 - Reimprimir o menu principal");
        System.out.println(" 0 - Encerrar o programa");
        Thread.sleep(1000);
        System.out.println();
        System.out.println("2. COMO REGISTRAR LOGS:");
        System.out.println(" - Escolha a opção 1 no menu.");
        System.out.println(" - Informe a quantidade de registros que deseja adicionar.");
        System.out.println(" - Para cada registro, insira:");
        System.out.println(" > Mês: Número entre 1 e 12.");
        System.out.println(" > Dia: Número entre 1 e 31.");
        System.out.println(" > Tipo: 'P' (Pessoal) ou 'E' (Estudantil).");
        System.out.println(" > Log: Descrição do registro.");
        Thread.sleep(1000);
        System.out.println();
        System.out.println("3. COMO CONSULTAR REGISTROS:");
        System.out.println(" - Escolha a opção 2 no menu.");
        System.out.println(" - Configure sua consulta.");
        System.out.println(" - Informe:");
        System.out.println(" > Mês: Número correspondente ao mês.");
        System.out.println(" > Dia: Número do dia.");
        System.out.println(" - Escolha se deseja filtrar por tipo ('P' ou 'E').");
        System.out.println(" - O programa exibirá os registros correspondentes.");
        Thread.sleep(1000);
        System.out.println();
        System.out.println("4. COMO REIMPRIMIR O MENU:");
        System.out.println(" - Escolha a opção 4 para exibir o menu novamente.");
        Thread.sleep(500);
        System.out.println();
        System.out.println("5. COMO ENCERRAR O PROGRAMA:");
        System.out.println(" - Escolha a opção 0 para sair.");
        Thread.sleep(500);
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
        System.out.println("_Agenda com consulta_");
        System.out.println("1- para REGISTRAR ");
        System.out.println("2- para CONSULTAR REGISTROS");
        System.out.println("3- para ver como operar a agenda");
        System.out.println("4- para imprimir o MENU novamente");
        System.out.println("0- para encerrar o programa");
        System.out.println("                                              dev.by eduardo kinzo e victoria, LP1; 2024");
        System.out.println("----------------------------------------------------------");

        System.out.println("O que você deseja fazer?");
    }

    public static void printReference() throws InterruptedException {
        final String NERD = "                                                                                                                                                          \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                               .     .    .                            . ....  .                                                                \n"
                + //
                "                                                               . ... ..                                   ::.  .....                                                            \n"
                + //
                "                                                             ..  =@@@@@@@@                             +@@@@@@@@-.:.....                                                        \n"
                + //
                "                                                        .....*@@@@@@@@@@@@@                          .=@@@@@@@@@@@@@-::....                                                     \n"
                + //
                "                                                   ... :=@@@@@@@@@@@@@@@@@@-..                       .@@@@@@@@@@@@@@@@@@#=:.......                                              \n"
                + //
                "                                              ..  .:+@@@@@@@@@@@@@@@@@@@@@@...  .. ...................=@@@@@@@@@@@@@@@@@@@@@#=:.... ..                                          \n"
                + //
                "                  .::::::::::::......:::::::::::+@@@@@@@@@@@@@@@@@@@@@@@@#::---:::::::::::::::::-:-----=@@@@@@@@@@@@@@@@@@@@@@@@#--:::::::::::::::::::::::::..:...              \n"
                + //
                "                *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#             \n"
                + //
                "                =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-             \n"
                + //
                "              .   -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-              \n"
                + //
                "                 .  .+@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*:                \n"
                + //
                "                       =@@@@@@@@**+***###***###**#***####****##*###################@@@@@@@@@@@@@%%%%%%%%%%%%%%############**#####******########*#**#@@@@@@@@%  .                \n"
                + //
                "                 .     :@@@@@@@*                     .:=+*+=--.               .....=@@@@@@@@@@@@=-------:::::::::::::::--=--:.                      -@@@@@@@=                   \n"
                + //
                "                        @@@@@@@@                  -+##%%%%@@@@@%+:               ..@@@@@@@@@@@@@-::.:......      :+%@@#*++====-::                   *@@@@@@@.                   \n"
                + //
                "                        *@@@@@@@                -*###%%%%@@@@@@@#*=:            ..=@@@@@@@@@@@@@#::::.:::.       =@@@@@#**++===----.                @@@@@@@@  .                 \n"
                + //
                "                        :@@@@@@@#              +*++#%@%@@@@@@@@@%*++=           .:@@@@@@@@@@@@@@@+::::::::     .:.*@@@@@#**++===-=-::              -@@@@@@@=                    \n"
                + //
                "                        .%@@@@@@@              +**+*%@@@@@@@@@@@@#++++:         :+@@@@@@@@@@@@@@@@:::-:::.    . ..*@%@@@@%***+++==---:             %@@@@@@@.                    \n"
                + //
                "                         =@@@@@@@-            -+***#%@@@@@@@@@@@@%****+.        :@@@@@@@@@@@@@@@@@*--::--.    .. -%@@@@@@@%#**++++==--:            @@@@@@@*                     \n"
                + //
                "                         :@@@@@@@%           :****#%@@@@@@@@@@@@@@#*#*#-        +@@@@@@@@@@@@@@@@@@-------.  .  =%@@@@@@@@@%##**++++===:          =@@@@@@@=                     \n"
                + //
                "                          %@@@@@@@          +****#%@@@@@@@@@@@@@@@@%%%%=       .@@@@@@@@@@@@@@@@@@@#--------+**%@@@@@@@@@@@@%%#***++===:          @@@@@@@@.                     \n"
                + //
                "                          =@@@@@@@-         *##%%@@@@@@@@@@@@@@@@@@@@@@=.     .=@@@@@@@@@@@@@@@@@@@@-=---=--%@@@@@@@@@@@@@@@%@%###**++=:          @@@@@@@*                      \n"
                + //
                "                          :@@@@@@@%         -%@@@@@@@@@@@@@@@@@@@@@@@@#-.......@@@@@@@@@@@@@@@@@@@@@#=---==-+@@@@@@@@@@@@@@@@@%%%##***=.         +@@@@@@@:                      \n"
                + //
                "                           *@@@@@@@-         =%@@@@@@@@@@@@@@@@@@@@@@@=::.....+@@@@@@@@@@@@@@@@@@@@@@=-=-====*@@@@@@@@@@@@@@@@@%%%###+.          @@@@@@@#                       \n"
                + //
                "                            @@@@@@@@:         -#@@@@@@@@@@@@@@@@@@@@%=-::.::.=@@@@@@@@@%%%%%@@@@@@@@@%-==-====*@@@@@@@@@@@@@@@@@@@@#=:          @@@@@@@@:                       \n"
                + //
                "                          . :@@@@@@@@+        .-+%@@@@@@@@@@@@@@@@@*==-:::.:+@@@@@@@@@%%%%%%%@@@@@@@@@@=====---=#@@@@@@@@@@@@@@@@%*-.         -@@@@@@@@+ .                      \n"
                + //
                "                           . -@@@@@@@@@-       ..-+#%@@@@@@@@@@%%*+--:::::-#@@@@@@@@@%#######%@@@@@@@@@@#=-==---=*#%@@@@@@@@@@@%*=-.        .%@@@@@@@@+                         \n"
                + //
                "                              .@@@@@@@@@@+        .:-=+*#####*+=---:::.:-*@@@@@@@@@@%***+++***%@@@@@@@@@@@#=----:-==**#%%%%%#+==::.       =%@@@@@@@@@-                          \n"
                + //
                "                           .    =@@@@@@@@@@@%=      .....:::::::...::-#%@@@@@@@@@@%#*===++++==*#%@@@@@@@@@@@%*+-:::----====--::...   .-+%@@@@@@@@@@%                            \n"
                + //
                "                               ..*@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%@@@@@@@@@@@@@@@@@#+=============*#%@@@@@@@@@@@@@@@@@%%%%%%%@@%%%%@@@@@@@@@@@@@@@@%.                             \n"
                + //
                "                                 ==*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+==-============-=+#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#  .                             \n"
                + //
                "                                 ..:-=*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*=----============----==*%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%+-.    .                           \n"
                + //
                "                                .......:-+#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#+=-------===========---------=*#%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*=-:...                                \n"
                + //
                "                                 ..........:::-+=+**##########*+++++=----:::::------=========--------:::------==++****#########**+==--:.........                                \n"
                + //
                "                                 ..:.......-+-............:.....::....::::::---------=======--------:::::::::.......:::::.::..:---:............                                 \n"
                + //
                "                                  .:....:..:==:..........:==-.........:.:::::-----------------------::::::::..................:+*+-...........                                  \n"
                + //
                "                                  ..::...................:=**-..........::::::---------------------::::::::::........=+-..:...-+=-::..::...:..                                  \n"
                + //
                "                                   .:::::.::::..:.........-==-.......:::::::::------======-------------::::::.......=**=::......:..::.....::..                                  \n"
                + //
                "                                   ..:::::::::..::...................:::.:------------===------------:::::::........-==-...:..:::::...........                                  \n"
                + //
                "                                    :::::::::----::::::............::.-@@@@@%##*******************##%#@@@@@+...............::....:....:::::.                                    \n"
                + //
                "                                    .::::::::=+*+-:::::::..........:::@@@@@@#*+===================++*#@@@@@@*:::::::......:::.::::::::::::::                                    \n"
                + //
                "                                      ::::-:::-=--:::::::::::::..::.:-@@@@@@#==-----------:-------===*@@@@@@#:::::::::::::::..:::::::::::::                                     \n"
                + //
                "                                      .:-:--::-::-::::::::::::::::::::%@@@@@#=:.:................:::=+@@@@@@-:::::::::::::::::==-::::::::.                                      \n"
                + //
                "                                       .:-----------:::::::::::::::::::-*@@@#:..                . .::+@@@#=::::::::::::::::::::-:::::::::                                       \n"
                + //
                "                                         :-------------::::::::::::::::---==+-                      -*++----::----:::::::::::::::::::-:.                                        \n"
                + //
                "                                         .:-------------------:::::----::-=-++-                    :=+=---------------:::::::::::::---.                                         \n"
                + //
                "                                           .---=-----------------------------==+****+++++++++***++++===-------------------:::----:--:.                                          \n"
                + //
                "                                             -==---------------------------------===+++++++++++=======--===------------------------.                                            \n"
                + //
                "                                              .-==------=-------------------===================-============--=------------------.                                              \n"
                + //
                "                                                :===========---------------=========================================-==------==-.                                               \n"
                + //
                "                                                  :-=====================================================================--==:.                                                 \n"
                + //
                "                                                  ...-==============================================================+======-  . .                                               \n"
                + //
                "                                           ....... ....-================================++======+++++++++++++++++++++====:...... .......                                        \n"
                + //
                "                                  .................:::.:::-=+==++++++++++++++++++++++++++++++++++++++++++++++++++++++=-::::::..............                                     \n"
                + //
                "                            ...............:::::::::----------=++++++++++++++++++++++++++++++++++++++++++++**++***+=:---:--:::::::::.................                           \n"
                + //
                "                         .  ...........:::::::::------==--==++++++++++++++++++++++++++++++++++++++++++*********++========-----:-::::::::.............                           \n"
                + //
                "                        ..............::::::::------=====++++++****###*##**********++********************#####****++++++====-------::::::::::..........                         \n"
                + //
                "                        .............::::::::-----=====+++++****####%%%@@@@%%%%%%####*****######%%%%%%%@@@%%%####***++++++=====-----:::::::::..........                         \n"
                + //
                "                        ...........:::::::::-------=====++++*****###%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%####****+++++=====-------:::::::::.........                         \n"
                + //
                "                      ..............:::::::::-------======+++++****#####%%%%%@@@@@@@@@@@@@@@@@@@@@@@%%%######*****+++++======-------:::::::..............                       \n"
                + //
                "                         .. .............::::::::-------=======+++++++********####################********+++++++=======------::::::::::................                        \n"
                + //
                "                               .............::::::::::::--------=========+++++++++++++++++++++++++++++++=========-------:::::::::::.:.............                              \n"
                + //
                "                                     .................:::::::::::::-----------------------------------------:::::::::::::::.................. ..                                \n"
                + //
                "                                         .. ...................::::::::::::::::::::::::::::::::::::::::::::::::.....................                                            \n"
                + //
                "                                                          .. ..........................................................                                                         \n"
                + //
                "                                                                      .............       ..     ........                                                                       \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "    :......................................:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::........................................................    \n"
                + //
                "    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n"
                + //
                "                                                                                                                                                                                \n" //
        ;

        final String MESTRE = "***++++++++++**+**+++++++++++++++++++++++++++++++++++++++++++++++++++++++***+*******************+==--=====+++****************************############################***********++++**\n"
                + //
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++***+++**************#*#####*######*####****************************###################******####**#######************++++**\n"
                + //
                "**+++++++++++++++++++++++++++++++++++++++++++++++***********##***######******#################**####****#####*****##********#####****#***#**#####*********#**#######************++++++\n"
                + //
                "***+*+++++*+*++**+++++++++++++++**++*************+++*#########*+**********#######*#############*#######***######**###*******###*************####*****************###************++++++\n"
                + //
                "*******++******++*+++++++****************+***+++++++*######*#**#*******##*##********################**########%%###************************####********************#***+********++=+++\n"
                + //
                "*****+++********************##########*****+*+++++++*########**************##********#*####################**#######*********####************##******+++++************++**++++++===+++\n"
                + //
                "******++++++********************######**++++++++++++*####****************####***#######*#####**#########################******##***********************+++++*********++++++++++====+++\n"
                + //
                "****+++=+++++++++++****************###**+**+++++++++*####**************####*****###########*###**##**###########%#%%%########******++********+**++**+++++++==********++++++++++==-=+++\n"
                + //
                "*++========++++++=+*************######***+++++++++++******************###******##*######%###########################%########*****+++++++++++++++++++++++++==+********++++++====--=+++\n"
                + //
                "+++=======+++++**++*************######*++**++++++++*****####*********##******############%#########*############%%%###%%%%#####*****++++=======++=+++=+++++==+********+==========-====\n"
                + //
                "++=======+++++**********************##*++++++++++++***#**##*******#####**+*+*####**###################*******#######%%%%%%#%#####*+++====-----====++++++=++==+*****++++===--=====-----\n"
                + //
                "+=======+++=+*########******************+++++++++++************############**#####****##*######%#***######*#****####*##############*+==+==----====++++++++===++++++=====------=-----==\n"
                + //
                "========++++****######***************++++++*+++++++***#*****############%#####%#*##******###**####***###############**#############*=====-----====++++++++========-----------------===\n"
                + //
                "++++=+********#########******##********++++*+++++++*******#############%#####%%########***###****################*#################*+===-----==+==+++++++====--=-------=====-=-----===\n"
                + //
                "+++++***+++#############***************+++++++++++****#***################%############+########**#*##%#**%%######*#################*=-----===++==+***++---========----===--===----===\n"
                + //
                "#***################**************+++++++++*+*++++********##############%##############*##############%%#*#%%####%###################*==-==++++==+++==+==--===========-==----------===\n"
                + //
                "++++**##############***********++*++++++++++++++++********######################***########################%%#######################***+==++++=====------=============--=--==-------==\n"
                + //
                "#######**##################*******++++++++++++++++********######*****####******#+++***#################*############################***+++=++==--==+----==-==========---=---==----===+\n"
                + //
                "###############################****+++=+++++++++++*******####***+++++=+++=====++==++****++##*##########*####################%%#####***+*++=====--==++======--=======----=====-------=+\n"
                + //
                "*############**#######**#########****++++++++++=++*******###*+========---------------====+**##########**#**#################%######*****++--=----=====================--==----------++\n"
                + //
                "+++*#########***################*********++++=--=***********+===-------------------------=++***####**+=++=++*******##################**##=-------==========-==========--=--------=-==+\n"
                + //
                "=++++****#*##**#####*##########***+++****+=-----+***#******+=-------------------------------=++***+=---------====++++*****##########***##+==------=--===========-=====------------====\n"
                + //
                "==++++++********##***#####*#####***+++++==-----=**###*****+=---------------------------------===------------------=====+++**#########**##*==-----====----=============---=--------====\n"
                + //
                "++=++++++**#****#***######***#****+++++=-------+***#*#***+=-------------------------------------------------------========++**###########+=-------===----=============-----=------====\n"
                + //
                "+++++++++***#####***######*****++++++++=------=***###****=---------------------------------------------------------========++***#########+=-------====--==============-------------===\n"
                + //
                "===+***+++****##***######***++=====+**=--------+**###***+=--------------------------------------------------------==========++**#########+--------====================------=---------\n"
                + //
                "====++*+++*********#####****+=====+**=--------=***#*###*+=---------------------------------------------------------==========+**#########+--------===---=-----------------------------\n"
                + //
                "====-=++++++****#########**+==--=+**=-------==***#**###*+=--------------------------------------------------------===========+*##########=--------=-----=--------------------=--------\n"
                + //
                "====--===++++++*#######**+===--=+**+-------==**###*####*==--------------------------------------------------------===========++*#*#######=-------=========---=---------===------------\n"
                + //
                "==========++++++*******++===--==+*++=-----==+**#######*+=---------------------------------------------------------===========++**#*#*####=-------==========------------======---------\n"
                + //
                "=====---==++++++++++++++===---=++++++=---==+**########*==---------------------------------------------------------===========+**########*=-------============----------=======-==-----\n"
                + //
                "=====----=+++++++=========------++++=---==++***######*+=---------------------------------------------------------============*##########=--------=======-==--=---------======-------==\n"
                + //
                "===================----===-------------==++***#######+==---------------------------------------------------------===========++*#########*--------=======--==-=--------======----======\n"
                + //
                "==============--------===-------------==++**++*######+=----------------------------------------------------------==========+++*#########+--------========--=-===--==-==--===-----=====\n"
                + //
                "=============---------===-----------===++***==*#####*=-----------------------------------------------------------=========++++*#########-------==========---==-----=====----==--------\n"
                + //
                "==============--------========----====++***+--=*####+-------------------------------------------------------------========++++*#########=--===-=============--------=--======--=--====\n"
                + //
                "-=================================++++*****=--==+*#*=-------------==----------------------------------------------========+++++#########+-====-==============-------------===--=======\n"
                + //
                "============================++++++++++*****=----=*#*=------====+++****+++++++==-------------------------------------=====++++++*########=====---==============--=----=----===========+\n"
                + //
                "===========================+++++++++++*****=-----+#+-------======++++++*******+=--------------------------------==---====++++++*######*+=====--============-===--====------===========\n"
                + //
                "==========--=========++++=++++++++++++*****+------*=------------====++++**+++++==-----------------==+***+*****+++++======++++++######*+=-===---============-==------------------------\n"
                + //
                "====================++++++++++++++++++******------+=----------==+**++###+##=++++==---------------==++*******+++****+++===++++++######+=--=======---=======-----------------------=====\n"
                + //
                "===================++++++++++++++++++*******=-----+=---------===++=--=*****--=+=====-----------===++**++*++==--====+++++==++=++####*+=---=-=--------=-==----===--------===============\n"
                + //
                "====-=++==---====++++++++++++++++++++*******+-------------------=======++=---========--------==++++++=+##+####*+==============+###+-==----------==---------===--------================\n"
                + //
                "=+=-==++==--==+++++++++*+++**+++++++*********=----------------------=-=-=======--====-------==+=====---+*#**+=+#*+============+##+--==---====---==----------==--===----===============\n"
                + //
                "=++++=====---=+++**++++*+++++***+++++********+---------------------------=====---===--------==+=========+++====+*+============+#*----=--======--==----------=----==----==--====---====\n"
                + //
                "=++***+====--=+++**++++*++++******+++*********=---------------------------------====--------==+=--====================-=======**=----=--====---==-----------=----------=========--====\n"
                + //
                "==+**++=--====+**++++++*+++++****##***********+---------------------------------------------=====--===============------=====++=-------==------==----------====------=================\n"
                + //
                "==+++=+*+====+****++++++++++++****##***++******=--------------------------------------------======-----------------------======-----=-===-----====----------==-------=================\n"
                + //
                "++++++++======++****++++**+++++****##*********=---------------------------------------------=====-----------------------=========--=-===------===---==---====---------===========-==--\n"
                + //
                "+=============+***************++****#*********----------------------------------------------=====-----------------------====+=---=----===--==--=--=-------------------================\n"
                + //
                "*+========+++++**********++++++++*******++****+---------------------------------------------=====-----------------------===++---------=======---====------------------==-----=========\n"
                + //
                "*++=+=====+++++++*******++++++++++*******++****+---=-==-------------------------------------=====----------------------====++-==-----==----==--====------==----=------===--------=====\n"
                + //
                "**+==+====++++++*+*****+++++++++++++*****+++******+====--------------------------------------====---------------------====++=---=----==---------===------==-----------===----=-=======\n"
                + //
                "***+======++*+++++*****++++++==+++++*****+++*******=-==---------------------------------------===--------------------=====++--------===---------===-----===---------------------------\n"
                + //
                "+**++=-=====+++++++***++==========+++++++++++*****+==------------------------------------------===------------------=====+++-------====---===-=======--=----------------------===-=---\n"
                + //
                "**+*+==-=====++++++++++===+================++++++++==-----------------------------------------====----------------=======++=------====------=------=--------===----=-===============--\n"
                + //
                "**+++=====+++=======+=======================+++++++==-----------------------------=-----------====---------------========++=------------------==------==---===-----================---\n"
                + //
                "*++++=====++++==============================+++++++===---------------------------====-----=======----------------=--======+===-=--------------==-=--=------==----=-================---\n"
                + //
                "*+++++====+++================================++++++=====-----------------------------===========---------------------=========-----------====-==-=--==-=---===-------===============--\n"
                + //
                "*+++++====+++=================================+++++=====------------------------------------===----------------------========----==---========-======------==------=-================-\n"
                + //
                "*++++++==================++====+++=========--=++++++===---------------------------------------=----------------------=====-=-------=--================----=====-==---================-\n"
                + //
                "*++=++++===============+++++++++++++++++++====+++++++===---------------==++=======----------=========---------------====++------------=============---=--=====--====================--\n"
                + //
                "+++====+==============++++++++=+++===+===========+++++===----------------=+++===================+*+===--------------====++------------====+=====-====----=============================\n"
                + //
                "++++====+=-==+++++=====================-=========++++++==-----------------=====---------------=++==-=--------------====++=----------============-=====-----=========-=================\n"
                + //
                "+==+=========+++**+=======----========+==-=====++++**+---------------------=======--------==+++===----------------=====++------------===========-=====---=========----======+++====---\n"
                + //
                "+==++=========+++=+++==-=+==---=========+==--===+++=-------------------------============++++++==--=------------======++----------==-============================---=====+++++======--\n"
                + //
                "+==++=======+=+====+++=---=+==--==+=======++======-----------------------------==-=-==--===++===---==------==========++=----------=====================-===-======================-==-\n"
                + //
                "===++=======+======++++=---=+++=-===+===========---------------------------------=============-----=-----==========++*=------------========================-=====================-----\n"
                + //
                "===++=======+======+=++*+----=++======++===----------------==-----------------------=====--------------===========++**--------------====================--====-----=---====--=====--=-\n"
                + //
                "===================+=+++*+=---=+++=----=++==-------------=--==-=-------------------------------------===========+++++-----------------===========---===========----=======-=======----\n"
                + //
                "=====--=+=========++==+++++=----=++=---------------------+----==----------------------------------============+++=++=-----------------======--====---==---=====-=-----================\n"
                + //
                "====---===========++===----------------------------------*=----===------------------------------============+++===+++=+++=------------=---===--=====--=+=====-=====---=========+======\n"
                + //
                "===---==+=-==--------------------------------------------*=-----=====-------------------------============+++====+++++++++=+----------------=--====--==++=====-=======================\n"
                + //
                "=====--++==---------------------------------------------=+=-------=====----------------------===========+++=======+++++++++=-------------------==++===================================\n"
                + //
                "====--=++-----------------------------------------------++==-------=+===---------------------========++++========++++++++++----------------======++*++++======-============-==========\n"
                + //
                "===-=+*+------------------------------------------------++===--------=+====----------------=======+++*=----======+++++++++=------------------===++++++++++=====----================+++\n"
                + //
                "-=+++++=------------------------------------------------=====----------=+++====---------======+++*++=-----==========+++=++-----------------------=++++++++=====----================++=\n"
                + //
                "==++*+=-------------------------------------------------=====-------------==++++=========++++*++=--------=================---------------------------===========-----======+++=-====++\n"
                + //
                "==+*+==-------------------------------------------------======------------------====++++++==-------------================---------------------------------===-=============++======+++\n"
                + //
                "+==-=-=-=-----------------------------------------------====----------------------------------------------==============---------------------------------------=-===-==========+===+++\n"
                + //
                "=+===-=---------------------------------------==--------=-------------------------------------------------=============-------------------------------------------===-======++++===+++\n"
                + //
                "=====--------------------------------------=+*+++--------------------------------------------------------=========--==-------------------------------------------------=====-==-=--===\n"
                + //
                "====-------------------------------------+=+==------------------------------------------------------------=====--------------------------------------------------------------=======++\n"
                + //
                "-=-=-----------------------------------=---------=----------------------------------------------------------------------------------------------------------------------------===+++++\n"
                + //
                "-=-----=---------------------------===-----------==--------------------------------------------------------------------------++-------------------------------------------------=+++++\n"
                + //
                "-------=-----------------------=++---------------=-**+----------------------------------------------------------------------=--+++------------------------------------------------=+++\n"
                + //
                "-------=---------------------------------------------=++-------------------------------------------------------------------==----=++------------------------------------------------=*\n"
                + //
                "---=---=---=-------------------------=-----------------=-+++=-------------------------------------------------------------+=-=-----=*+------------------------------------------------\n"
                + //
                "---=---=-------------------------------------------------=-===-----------------------------------------------------------+=-=------=-=++----------------------------------------------\n"
                + //
                "----------------------------------------------------------==-==--------------------------------------------------------++=------=-=-----=---------------------------------------------\n"
                + //
                "-------------------------------------------------------------===-----------------------------------------------------=*====-----------------------------------------------------------\n"
                + //
                "---------------------------------------------------------------=*=-----------------------------------------------***+=----------------------------------------------------------------\n"
                + //
                "=-----------------------------------------------------------------++=------------------------------------------++---------------------------=-----------------------------------------\n"
                + //
                "=-------------------------------------------------------------------====-------------------------------------+------------------------------------------------------------------------\n"
                + //
                "=--------------------------------------------------------------------------=------------------------------===-------------------------------------------------------------------------\n"
                + //
                "=---------------------------------------------------------------------------=+=------------------------===--------------------------------------=-------------------------------------\n"
                + //
                "---=--------------------------------------------------------------------------===-----------------=+===-------------------------------------------------------------------------------\n"
                + //
                "-----------=--------------------------------------------------------------------=-=--------====-=-------------------------------------------------------------------------------------\n"
                + //
                "-------------------------------------------------------------------------------------=+==---------------------------------------------------------------------------------------------\n"
                + //
                "=-------------------------------------------------------------------------------===+==-=----------------------------------------------------------------------------------------------";

        Thread.sleep(500);
        System.out.println(NERD);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        Thread.sleep(500);
        System.out.println(MESTRE);
        Thread.sleep(500);
        System.out.println(NERD);

        String SenhorLó = "=+*+==-=***-=+++..+=*%%@@#%@@#**%@#@@#*+==+-=:--===+=+###*++==+*##++++++---==*+---------*%#*-=*#@@@%%-=%@@@@@@@@@@@%%%#%@@@@@@#=#*==+*+*#+==#\n"
                + //
                "==*+*#=+%#*%=:++..=#%##%%%@#%%@#%*%@@@@#*====-==-=-----:+**+#*%+***===+@+=*++=-::---------=**%%@@@%%%+#@@@@@%%@@@@@@@%@@@%@#+%%+=%#%@%%#=+#++\n"
                + //
                "#@*#*+*+##+=*--:.:-%@#%%%@@@@@@%*%%%#####*===**==-=++=++*=*==++*+*#+=*%%###%%*==++==--=---+%@@@@#*#%*=@@@@@@@@@@@@@@%#%@@@%#**+*##@%*+++#+%#%\n"
                + //
                "=--==*#%@@%@@*+=.=*#**=#%@@@@@@@#@@@@@@%%#*=**+++++=++====+=+#*%@@@@@@@@@@@@@%@@@%%####%---**+*#@@@@@%%+*#%@@@@@@@@@%@@@@@##+++==##%=+#*#@@@@\n"
                + //
                "++-++**#++*#***+:-++++==#+++##%@@@%*+*#%@%##*+#****++++=++#%@@@@@@@@@@@@@@@@@@@@@%%@@@%#*==*%@@@@@@%###%@@@@@%**#*%@@@@@@@==**+-=#*@@%@@@@@@@\n"
                + //
                "#**##*+++=+++**%+=--=++++====+=+++=====*%%%+*##++##*++*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%@%%%%%@%###%@@*+*@%###*%@#%%@%##%%%*%@@@##%@@@@@@%@@@@\n"
                + //
                ".....:=+*=#+##==-::%++=======-*+==++=***%%####%###*#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@%%%%%%%%@@@@@@%#*##%%@@@%*+*#%@@@%++++*#%@@@%%@@%+%@@%\n"
                + //
                "=-::..:*##*+**++-:-+++=#+==*******++####%%##%%%#%%#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@%@%%#%%#%%*=*#%%@@@@@#*%####%@###+#+==+#%@@@%####%#%@@@@\n"
                + //
                "###%####%*==+#*+-..=+==-==---+*#@%%%%###*##%%%#=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%@%%%%#%%%####@@@@%#*#*%@@@@@@%=:--=*%@@@@%****#%@@@@%##+\n"
                + //
                "%%###%@@##%%%%#*+..-*=--+=++##*++%@%###%%#*##%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@%%%%%%%%%%#%%###%%@@@@@@@@@@@#*++#*@@@@@@%*++#%@@%#####*#@#\n"
                + //
                "*@*#%%%@##@@**@#=::-##+#*%#+***=-#@@@@@##%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%@%%%%%%%%%####%@@@@@@@@@@@@%%@@%%#**#%@@@@@%%#**+#@@@@#\n"
                + //
                "=#-*@%@@*+**%*@*+-::#*%@@%%%+++*+#@%%****#%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%##%##%#@@@@@@@@@@@@@@@@@@%@@@@@%#*+*#@@@@@@%%#+\n"
                + //
                "****@%@@%=+@%##=+:::#%%@%%@%***#%@@*==+**#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%@@%%%#%%%#%###%@@@@@@@@#%@@@#%@%%@@@@@@%+#@@@%%#*+*%@%\n"
                + //
                "%%%%####**#=+@#*#:::%@@#@@@%++=++*=-**+*#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%@@%%%@%#*#%%%%@@%%%#*@@@@@@@@@@@%%@@@@@@@@@@@%%@%#\n"
                + //
                "@@##%%@%*+-*##-==:::#@@@@%%%+%*+-+++****#%@@@@@@@@@@@@@%%%%###%%@@@@@@%%@@@@@@@@@@@@@@@%%%%%@@%%@@#*##@@@@@@%%%#%%@@@@@@@@@@@@@#@@%%@@@@@@@@@\n"
                + //
                "@%%%%%%#+##+@====-::+@@%%@@+#%@*%*=+#%#%%@@@@@@@@@@@@%##********##%##%%%%%%%%%%%%%%%%%%@@%%%%@%%%%#####%@**@@@@@@@@@@@####%@@%@%@@@@@@@@@%%%%\n"
                + //
                "##*#+%@==#*%%=++*-.=-%%%%@%#%%%*=##=+%@@@@@@@@@@@%%%##********+*****#################**+#%%%%@@@%%%##+=*++####%@@@@@@@@@@@%@@%#***%@@@@@@@@@@\n"
                + //
                "%*+++#@@#*#@%*++%*==+%%%#@+@@%#===#==+%@@@%@@@@%%%%##*****+++++++++******++++++*******++=+*##%%%@%%%#=-+*+@@@@%%%##*#*####@@@%@%@@@%%@%*#%%@%\n"
                + //
                "+#####%@=*@@%#@%*+===#*###%@@*+=-#-=#=*%%%@@@@@%###*****+++++++++++++**++++======++++++===+*#%%%%%%%#++**#**#%@@#%#%@@@#=*%***+**#%%@%%%%%%@@\n"
                + //
                "%%%*##%@%#%@@%+==+--=###*+**%*--=+*=+#==#%@@@@%###*******+++++++++++++++++=============--==+#%%%%%%%#++@@@+#%#+=*+--++@%@@@#%#+*#%%###***##%%\n"
                + //
                "#%%%+##%###++#%=*+-:-+**#+*=#+-=+**-:*+*+%%@@@###********+++++++=++++++++=========-==------=*#%%%%%##+***==*#*#+****%@@@%%**+#+=+#%#%%%%#%%%%\n"
                + //
                "+####+#*%%+===*#**-:-*@%%*+**++==*%#+=%+-*%@@%#***********++++++++++++++++=====-------=-----=*%%#%%%#*-=+==+**+#@@@@@@@%%#**#%@#+=**#####*#%%\n"
                + //
                "+%*#@###@*+%**#*#+-:-+%%%%*#*+===++++=+=-=*@@%****++*+++++++++++++++++++++======------==-----=*#%%%%#*==-=-+#*#@@%@@@@@%:......:=*#%%%@%#%*+*\n"
                + //
                "%%%%%#####*%###*@#-:--*#@@%##*-=+++==-=+===%@@****+++*+++++++++++++**+++=++++============-----=*##%%#*====*#*++%@@@@@@@@-....  .=**%@==%+=+==\n"
                + //
                "@%#@@%@@@%*%@@%*@%-:--+%###*#***-=*+==-::--+@@*+**********+*++++++***+****#%%%##****++===------+#%##***==-*==*%@@@@@@@@%%%*=--.-*#@@%*====---\n"
                + //
                "#%%@@**%@%+*#%%%@%=:::*#@%#*#*=*#*==++:::--=%@*+*#%%%@@@%%%###***++**#####%%@@@@%%%%###*++-----=##*+=**+=-==+=*#%@@@@%#@@@%*=+%%@%@@@@%+===++\n"
                + //
                "*+**%***%%+++**#%+=:-:+#@@++#***+**=+*--+=-=#@+%@@@@@@@@@@@%%%####***#######%%####*******+==---=*#*==+*=---+*+#%@%%%%@@##%#@#%%%=+%@#=-=++--+\n"
                + //
                "+===#=*-%@%++=+*%%+:::=+#*+*==+===+*+=+++=--*%#@@@%%%%%###%%####*#********###*****++++=====-----+*++++*---===-=*%%%%@@@%%@@@#%@%==%%-====+##%\n"
                + //
                "+==+#**=#%%%#@%#***--=-===-==--==+====:=----+######******###%%%%###****####%@@@@@@@@@%#*+====---=++++=+===-==*#%#%#%#*#%%@@@@#+*@*=+=***##%%%\n"
                + //
                "%*+++*#--==+%@%@@@+=:-===%==+=--+==*=+==-.-==*+***#%@@@@@@@@@%%%#*+==+*##%@@%%%##*++====---====---=+==+------:--+###%@@@@@%%@##---+*=-+##%@@%\n"
                + //
                "=#++*+====-==%#%%+%=:-==-*+++=-:--+*-+===--++*+*#%%#%%%%%%%%%%%##++==++**#####****+++++====-------==--=----::-++###+*%%%%@@#+----+**##%%%%@@@\n"
                + //
                "*#+==+=-+--=%**+++==+-===++=-+-=-=++**+===-+*++++******#########**+=====++++******++++===-===--------------==--+%%*+#%#%%#%@##+++*#%%%%%%%%@@\n"
                + //
                "=#***+=+++===+++==-===-===+-+=====+*+**+*====*=+****####*********+=========+=+++++++=====--===---:-----==---*%#*+#%%%%##%%@##%##%%%@@@%%@@@%@\n"
                + //
                "==*#=**++=-======+--+=:=--+===++=+=*+++*#+++===+***++++*********++=======+**++==========-----=---::::--:-==::-=%%#=%@@%%%%##@@@%@@%%%%%@@@@@@\n"
                + //
                "+#%%@#+*=-==+===+==+=====-=====++=+++*+++*==-=++****+*+****#%#**++=======+*#***+++======--===--------=+=-++=-:-**#%++%%%%%@@@@@@@@@%%%%@@@@@@\n"
                + //
                "+%++@#*+=---===+-:=:::.-=+====-++**+=++++==++-=+**********#%#****++==-=====###***+++++=======-----========++=--*%%%-%@%%%%%%@@@@%@@@@@@@@@@@@\n"
                + //
                "#@*+*=+*---:-:=*+:-:-::--=+=+=**+++=*%**==++++++********##%%#*****++=======*##%#****++++======---=+%#+=====##++#%%@%%%@@@@@@%%%@@@@@@@@@@@@@@\n"
                + //
                "=#@%++++=-+--==**.:.::--++=++*###*#=+=*##+++=++++****####%%%#******+++++++**###%%##**+++++=====---=%*#**----=%@@@@@%@@@@@@@@@@%%%@@@@@@%@@@%%\n"
                + //
                "**+*=****+*=--+++-=++=+===+=+==**#*#++****======****####%%%%%%%%%#***#%%%#####%%%%@##**++=======-#=-%%#%=:-+-#*+@@@%@@@@@@@@###%%@@@@@@%@@@@@\n"
                + //
                "=**==*+*#+**+++*=++==--===+++++*#=+*==+#=--=-==-***####%@@%%%@@@@@@%@@@%%####*#%%%%@@#*++======--*%+%%%%%-:*++%@@*@@@@@@%#====+#@@###@@@%@@@@\n"
                + //
                "###=+++*=++==+++=---==+===*+=+**++=*+%+-=-=-=+=-+***###@@@@%%%%#######*********%@@%%@%*++=+======%**%@@@#*=-*@*@@@@#=---=+-=-=+%%+-=#@@@@#--+\n"
                + //
                "##**-=*%****+++:-==+==+*=+=+=++=+++=*+*=:-====+-+****##%@%%@%%########*##*++=#%**+*#%#**+++=====-*#-#@@@@@*=%%@#*+:-+=+=+=-::::.=+#++*****=+-\n"
                + //
                "*##+==**#****==++++====++=========--===----=+===++*#####%%###%%%##*+++---==*++=====*%***+**====+@#=*=@@@@@@#@@%-+==++==-=--:--=:--**###**===+\n"
                + //
                "*##*#***+++===+++++*===-==+=:=========:=+====+==+=+*#######*#####***+++++++=======+*#*+**+++===-@@%==#%-::..:-+%++===---=-++==+=+#*#***+***+*\n"
                + //
                "-**+==#+==-====++**==---.-====-==-:===:-=-==+====+=+*######**#**#****+++++++======+#******++++-:@@@@=+%#%@@+**=++===-==*#+***%****#####*####%\n"
                + //
                "+#+=:**++========*++-+====-=+=+:::.:--:-==*=--++=++=+###%%#***###*##*****++=++====+*******++=---*@@@%+*===-======-=*++###*****###############\n"
                + //
                "=++=+++++=====-==+==+**+++=+=-++-::...:=-==:-#+#===++#*#%%#****#####%%%%#**++======+++***++=-----@@@@%#%%***==-:+*#=*############%%##%%%%#*##\n"
                + //
                "=*++=+====-==+======+++++===+=+**-=-..:--:=+##*-===***@@@%%#*****#######*+++++======****+*=------@@@@@#**##++##%#######%%%#%%%%###%%%#%###%##\n"
                + //
                "#*+-===---==+*===-==+++=+====*#%*+-==:.:--=+*###*+=+#@@@@@@%##********+++==========+***#*=------=%@@@@%#*#####%%%#%%%%%%%%###%%%%%%%%####**++\n"
                + //
                "====+*****++**##*+*=+=++==+==+=%@%*-==-.::-+#%%%%%*%@@@@@@@@@%####****+++++=++==+++*%*%*=-------*%@@@@%##*#%#*####%%%######%#%%%%##**++++++++\n"
                + //
                "+++=+++=+-=*+++++*#*##*+++==:-++***-:==-::---+#%@@%@@@@@@@@%@@%%%%####**+***++*+**#%%%#=-------=*%@@@@@###*#%%%#*###*##%%%%%%#*#****+++***#**\n"
                + //
                "****####*#*+++++***==+*#*+++==+=-++=-+==-:::=#@@@@%@@@@@@@@%#%@@@%%%########**#*%%@%%+=--------*#%@@@@@%##**#%#%%%####%#****##*##**#**##*****\n"
                + //
                "***########*##*####++==+*%#++++++=++*#*+=+#@@@@@@@@@@@@@@@@@###@@@@@%%%%%%###%%@@@%*=---------=*#@@@@@@%##***#@@%%%%%###%##***+*##++*####***#\n"
                + //
                "*#####%################**++##*+**++***#%@@@@@@@@@@@@@@@@@@@@%####%@@@@@@@@@@@@@%#+=--==-------+##@@@@@@%%##***#%%%%%%%%%%######*****####**#%%\n"
                + //
                "#########%%%%%%%%%%@%%%%@%=+=#%*##%%@@@@@@@@@@@@@@@@@@@@@@@@@##****##%@@@@@%%#+===---=-------+*##@@@@@@%#####**%%%%%%%%%%%%%%%%%##*#**++%%%#*\n"
                + //
                "#**#*#######%%%@@@@@@@@@@%%*%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#************++++===--=-------=**##@@@@@@%######**%%%%%%%%%%%%#%%%%######*+++=+\n"
                + //
                "%####+##%%%#%%%%@%@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#****+++*++++++========---=-=+***#@@@@@@%######**%%%%#%%%%%%#############**#*+\n"
                + //
                "+%*+##*%####%%@@@%@@@@@@%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%##***++++++++++========---==++**@@@@@@@@%#####***#%%%%#############%%#####*#**\n"
                + //
                "#%#%@%%######%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@###**++++==++++++=====----=++*@@@@@@@@@@%######***%%#########%#%%%%%%%########\n"
                + //
                "#*%#%%%%%####*%%@%@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#***+==============----=+*@@@@@@@@@@@%%######***#############%%%%#%#########\n"
                + //
                "%%%####%@@%%%@%@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#*+==-----=======---=+@@@@@@@@@@@@@@@@@@@@##**#%#########%%%%%%%##########\n"
                + //
                "%%%%%#%%%%@@%%@#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@#+==-----=====---=%@@@@@@@@@@@@@@@@@@@@@@@@@*#######%%%%%%%%%###########\n"
                + //
                "%@@@@@%@@@@%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*-----=======#@@@@@@@@@@@@@@@@@@@@@@%%%%########%%%%%%%%%%###########\n"
                + //
                "#%%@@@%%%#*%#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#=---====*@@@@@@@@@@@@@@@@@@@@@@@@%%#############%%#%#%%%%%%%%#####\n"
                + //
                "%%%%%#%%%@@@%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#====+%@@@@@@@@@@@@@@@@@@@@@%@@@%%%%#########%#%%%%%%%%#%#%######\n"
                + //
                "@@@%%%@@%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#=#@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%###%#######%%%%%%%%#%%#####\n"
                + //
                "@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%#%#%%%%%#%#%###%###\n"
                + //
                "@@@@@%%@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@%@%@%%%%%%%%%%%%%%%%%%%%%#%#%#######\n"
                + //
                "**##%@@@#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-:%@@@@@@@@@@@@@@@@@@@@@@@%%@%@%%%%%%%%%%%%%%%%%%#%%%#%##%#####\n"
                + //
                "#*#*##*%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@%%%%%%%%%%%%%%%%%%%%%%%%%#######%####\n"
                + //
                "-:+**###%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@%@%@%%%%%%%%%%%%%%%%%%%%%%%%%############\n"
                + //
                "=-=+-+##@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@%@@@@@@@@@@@@@@@@@%@%@%@%@%@%@%%%%%%%%%%%%%%%%%%%%#%#%#########";
        Thread.sleep(500);

        System.out.println(SenhorLó);

    }

}
