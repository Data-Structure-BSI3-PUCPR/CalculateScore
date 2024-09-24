import java.util.Scanner;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private final double[] activitiesGrades = new double[8];
    private final double[] raGrades = new double[4];

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("Bem vindo ao programa de cálculo de média da disciplina de Estruturas de Dados!\n");
        System.out.println("""
        \033[1mPesos por RA e por Atividade:\033[0m
        \033[1;38;5;225mRA1 (30%): \033[22;38;5;225mConcept Test (50%) + TDE 1 (50%);\033[0m
        \033[1;38;5;193mRA2 (30%): \033[22;38;5;193mConcept Test (50%) + TDE 2 (50%);\033[0m
        \033[1;38;5;153mRA3 (20%): \033[22;38;5;153mConcept Test (50%) + TDE 3 (50%);\033[0m
        \033[1;38;5;210mRA4 (20%): \033[22;38;5;210mConcept Test (50%) + TDE 4 (50%);\033[0m
        """);

        System.out.println("Ao obter a média de cada um dos RAs, sua \033[1mmédia final\033[0m é composta pela fórmula:");
        System.out.println("\033[1m(\033[1;38;5;225mRA1 * 0,3\033[39m) + (\033[1;38;5;194mRA2 * 0,3\033[39m) + (\033[1;38;5;153mRA3 * 0,2\033[39m) + (\033[1;38;5;210mRA4 * 0,2\033[39m)\033[0m\n");

        System.out.println("Agora vamos calcular sua média.\n\033[1;4mCaso ainda não possua alguma nota, insira 0 no campo.\033[0m");
        System.out.println("\033[1m-------------------\033[0m");
        System.out.println("\033[1;38;5;225m------- RA1 -------\033[0m");
        System.out.print("\033[1mConcept Test: \033[0m");
        activitiesGrades[0] = sc.nextDouble();
        System.out.print("\033[1mTDE 1: \033[0m");
        activitiesGrades[1] = sc.nextDouble();
        raGrades[0] = raScore(activitiesGrades[0], activitiesGrades[1]);
        System.out.printf("\033[1;38;5;225mMédia RA1: %.2f\033[0m\n", raGrades[0]);

        System.out.println("\033[1;38;5;193m------- RA2 -------\033[0m");
        System.out.print("\033[1mConcept Test: \033[0m");
        activitiesGrades[2] = sc.nextDouble();
        System.out.print("\033[1mTDE 2: \033[0m");
        activitiesGrades[3] = sc.nextDouble();
        raGrades[1] = raScore(activitiesGrades[2], activitiesGrades[3]);
        System.out.printf("\033[1;38;5;193mMédia RA2: %.2f\033[0m\n", raGrades[1]);

        System.out.println("\033[1;38;5;153m------- RA3 -------\033[0m");
        System.out.print("\033[1mConcept Test: \033[0m");
        activitiesGrades[4] = sc.nextDouble();
        System.out.print("\033[1mTDE 3: \033[0m");
        activitiesGrades[5] = sc.nextDouble();
        raGrades[2] = raScore(activitiesGrades[4], activitiesGrades[5]);
        System.out.printf("\033[1;38;5;153mMédia RA3: %.2f\033[0m\n", raGrades[2]);

        System.out.println("\033[1;38;5;210m------- RA4 -------\033[0m");
        System.out.print("\033[1mConcept Test: \033[0m");
        activitiesGrades[6] = sc.nextDouble();
        System.out.print("\033[1mTDE 4: \033[0m");
        activitiesGrades[7] = sc.nextDouble();
        raGrades[3] = raScore(activitiesGrades[6], activitiesGrades[6]);
        System.out.printf("\033[1;38;5;210mMédia RA4: %.2f\033[0m\n", raGrades[3]);
        System.out.println("\033[1m-------------------\033[0m");

        System.out.printf("\033[1mMédia Final: %.2f \033[0m", finalScore());
        System.out.println("\nPressione qualquer tecla para fechar! \033[31m<3\033[0m");
        sc.nextLine();
        sc.nextLine();
    }

    private double finalScore() {
        double finalGrade = 0;
        for (int i = 0; i < raGrades.length; i++) {
            double percentage = i <= 1 ? 0.3 : 0.2;
            finalGrade += raWeight(raGrades[i], percentage);
        }
        return finalGrade;
    }

    private double raWeight(double raGrade, double raPercentage) {
        return raGrade * raPercentage;
    }

    private double raScore(double conceptTest, double tde) {
        double percentage = 0.5;
        return (conceptTest * percentage) + (tde * percentage);
    }

}