import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int periodInYears) {
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * periodInYears);
        return searchRound(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return searchRound(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double searchRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateContribution() {
        int depositAmount;
        int periodInYears;
        int depositType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        periodInYears = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double result = 0;
        if (depositType == 1) {
            result = calculateSimplePercent(depositAmount, 0.06, periodInYears);
        } else if (depositType == 2) {
            result = calculateComplexPercent(depositAmount, 0.06, periodInYears);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + periodInYears + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateContribution();
    }
}
