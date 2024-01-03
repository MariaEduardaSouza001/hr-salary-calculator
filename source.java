import java.util.Scanner;

public class TrabalhoAV2 {
    public static void main(String[] args) throws Exception {

        System.out.println("|=============================|");
        System.out.println("|                             |");
        System.out.println("| ALGORITIMOS E PROGRAMAÇÃO 2 |");
        System.out.println("|  TRABALHO VÁLIDO COMO AV2   |");
        System.out.println("|                             |");
        System.out.println("|=============================|");

        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 1) {
            System.out.println("\n|=============================|");
            System.out.println("|      ESCOLHA UMA OPÇÃO      |");
            System.out.println("|                             |");
            System.out.println("|  1 - NOVO HOLERITE          |");
            System.out.println("|  2 - INFORMAÇÕES DO SISTEMA |");
            System.out.println("|  3 - SAIR                   |");
            System.out.println("|                             |");
            System.out.println("|=============================|");

            System.out.print("\nVOCÊ ESCOLHE: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nVAMOS CALCULAR UM NOVO HOLERITE");
                    break;
                case 2:
                    int a = 0;
                    System.out.print("\nCRIADOR DO PROJETO: \n\n||FELIPE GONÇALVES DE SOUZA||\n\n");
                    System.out.print("\nDESEJA VOLTAR AO MENU PRINCIPAL?\n|1|SIM|\n|2|NÃO|");
                    a = sc.nextInt();
                    if (a == 1) {
                        System.out.println("\n|ESCOLHA OUTRA OPÇÃO|");
                    } else {
                        System.out.println("\n|VOCÊ ESCOLHEU SAIR, ADEUS");
                        System.exit(0);
                    }
                    break;

                case 3:
                    System.out.print("\nSAINDO DO PROGRAMA, ADEUS|");
                    System.exit(0);
                    break;

                default:
                    System.out.print("\nOPÇÃO INVÁLIDA, TENTE NOVAMENTE");
            }

        }

        System.out.println("\n\nENTRE COM OS GANHOS DO FUNCIONÁRIO: ");
        System.out.print("\nSALÁRIO BRUTO: R$");
        double bruto = sc.nextDouble();
        System.out.print("HORA EXTRA: R$");
        double extra = sc.nextDouble();
        System.out.print("BÔNUS(SE EXISTIR): R$");
        double bonus = sc.nextDouble();

        double inss1 = 7.5 / 100;// Até R$ 1.320,00 7,5%
        double inss2 = 9.0 / 100;// De R$ 1.320,01 a R$ 2.571,29 9%
        double inss3 = 12.0 / 100;// De R$ 2.571,30 até R$ 3.856,94 12%
        double inss4 = 14.0 / 100;// De R$ 3.856,95 até R$ 7.507,49 14%

        double inss = 0;

        if (bruto <= 1320) {
            inss = bruto * inss1;
        } else if (bruto < 2571.29) {
            inss = bruto * inss2;
        } else if (bruto < 3856.94) {
            inss = bruto * inss3;
        } else {
            inss = bruto * inss4;
        }

        double cbir = bruto - inss; // cbir = CALCULO BASE IMPOSTO DE RENDA
        System.out.println("MOSTRE " + cbir);

        double irpf1 = 0; // Até R$ 2.112,00
        double irpf2 = 7.5 / 100; // De R$ 2.112,01 até R$ 2.826,65
        double irpf3 = 15.0 / 100; // De R$ 2.826,66 até R$ 3.751,05
        double irpf4 = 22.5 / 100; // De R$ 3.751,06 até R$ 4.664,68
        double irpf5 = 27.5 / 100; // Acima de R$ 4.664,68

        double irpf = 0;
              
        if (cbir <= 2112) {
            irpf = cbir * irpf1;
        } else if (cbir <= 2826.65) {
            irpf = cbir * irpf2;
        } else if (cbir <= 3751.05) {
            irpf = cbir * irpf3;
        } else if (cbir <= 4664.68) {
            irpf = cbir * irpf4;
        } else {
            irpf = cbir * irpf5;
        }

        double corte = 0; // CORTE = O VALOR QUE SERA SUBTRAIDO DO IRPF QUE SERA COBRADO

        if (cbir <= 2112) {
            corte = 0 + irpf;
        } else if (cbir <= 2826.65) {
            corte = irpf - 158.40;
        } else if (cbir <= 3751.05) {
            corte = irpf - 370.40;
        } else if (cbir <= 4664.68) {
            corte = irpf - 651.73;
        } else if (cbir > 4664.68) {
            corte = irpf - 884.96;
        }

        double aa = bruto - inss - corte;

        System.out.println("\nmostre" + corte);// TESTE TEMPORARIO
        System.out.println("\nmostre" + aa); // TESTE TEMPORARIO

        System.out.println("\n\n|=======================================|");
        System.out.print("|O FUNCIONÁRIO ULTILIZA VALE-TRANSPORTE?|\n\n|1|SIM\n|2|NÃO : ");
        int vt = sc.nextInt();

        float vt6 = 0;

        if (vt == 1) {
            vt6 += bruto * (6.0 / 100);
        } else {
            System.out.println("\n|NÃO USA VALE TRANSPORTE|");
        }

        double vr = 0;
        if (bruto <= 1320) {
            vr = 0;
        } else {
            vr = bruto * 3 / 100;
        }

        double va = 0;
        if (bruto > 3960) {
            va = bruto * 2 / 100;
        } else {
            va = va + 0;
        }

        double cv = 0; // CV = CONVENIO MÉDICO
        if (bruto <= 1320) {
            cv = 0;
        } else {
            cv = bruto * 4 / 100;
        }

        double resultado = bruto - inss - vr - vt6 - cv - va - corte;

        System.out.println("\n|      O VALOR DO IRPF É: " + corte);
        System.out.println("|      O VALOR DO INSS É: " + inss);
        System.out.println("|      O VALOR DO VALE TRANSPORTE É: " + vt6);
        System.out.println("|      O VALOR DO VALE REFEIÇÃO É: " + vr);
        System.out.println("|      O VALOR DO VALE AlIMENTAÇÃO É É: " + va);
        System.out.println("|      O VALOR DO CONVÊNIO MÉDICO É: " + cv);
        System.out.println("\n\n|      Salário líquido: " + resultado);

        sc.close();

    }
}
