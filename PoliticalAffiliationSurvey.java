import java.util.Scanner;

public class PoliticalAffiliationSurvey {

    private static final int TOTAL_QUESTIONS = 20;
    private static final int[] GUESS_POINTS = {10, 14, 18}; // Reference points (question #'s) to make early guess
    private static final double LIBERAL_THRESHOLD = 1.5; // Average score threshold for Liberal
    private static final double CONSERVATIVE_THRESHOLD = 3.5; // Average score threshold for Conservative

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean guessed = false;

        String[] questions = {
                "What is your view on the government's role in the economy?",
                "What is your stance on healthcare systems?",
                "How should education be funded?",
                "What are your thoughts on climate change?",
                "What is your opinion on immigration policy?",
                "What is your stance on gun control?",
                "What should be done about income inequality?",
                "How should the government handle social welfare?",
                "What is your view on foreign policy and defense?",
                "What is your stance on taxation?",
                "What is your opinion on abortion?",
                "How should the government approach housing policy?",
                "What are your views on labor and employment laws?",
                "What is your stance on same-sex marriage?",
                "How should the government handle environmental policies?",
                "What is your opinion on international trade?",
                "How should national infrastructure be managed?",
                "What is your stance on drug policy?",
                "What are your views on privacy and surveillance?",
                "How should the government approach energy policy?"
        };

        String[][] options = {
                {"A. Increase regulation", "B. Free market policies", "C. Mixed approach", "D. Minimize intervention"},
                {"A. Universal healthcare", "B. Private insurance", "C. Employer-based", "D. Personal savings"},
                {"A. Public school funding", "B. Charter schools", "C. Private school vouchers", "D. Parental responsibility"},
                {"A. Strict regulations", "B. Private sector solutions", "C. Renewable energy", "D. Climate change skepticism"},
                {"A. Open borders", "B. Strict controls", "C. Citizenship pathway", "D. Merit-based system"},
                {"A. Stricter laws", "B. Right to bear arms", "C. Moderate control", "D. No change needed"},
                {"A. Redistribution", "B. Tax incentives", "C. Social programs", "D. Market solutions"},
                {"A. Expand programs", "B. Limited support", "C. Reform programs", "D. Personal responsibility"},
                {"A. Diplomacy focus", "B. Military strength", "C. Economic sanctions", "D. Non-intervention"},
                {"A. Progressive taxation", "B. Flat tax", "C. Tax cuts", "D. Minimal taxes"},
                {"A. Pro-choice", "B. Pro-life", "C. Limited cases", "D. Government out of it"},
                {"A. Government housing", "B. Market solutions", "C. Subsidies", "D. Deregulation"},
                {"A. Stronger regulations", "B. Free market", "C. Union support", "D. Minimal regulation"},
                {"A. Full support", "B. Oppose", "C. Civil unions", "D. No government role"},
                {"A. Environmental protection", "B. Business-friendly", "C. Balanced approach", "D. Skepticism"},
                {"A. Free trade", "B. Protectionism", "C. Fair trade", "D. Self-sufficiency"},
                {"A. Government investment", "B. Private sector", "C. Public-private partnerships", "D. Minimal spending"},
                {"A. Decriminalization", "B. Strict enforcement", "C. Medical use only", "D. War on drugs"},
                {"A. Privacy protection", "B. Security focus", "C. Balanced approach", "D. Surveillance support"},
                {"A. Renewable energy", "B. Fossil fuels", "C. Mixed sources", "D. Market-driven"}
        };

        // Iterate over all questions
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer (A/B/C/D): ");
            String answer = scanner.nextLine().toUpperCase();

            // Score the answer
            switch (answer) {
                case "A":
                    score += 1;
                    break;
                case "B":
                    score += 2;
                    break;
                case "C":
                    score += 3;
                    break;
                case "D":
                    score += 4;
                    break;
                default:
                    System.out.println("Invalid input, moving to next question.");
            }

            // Check if it's a point to make an early guess
            if (shouldMakeGuess(i + 1)) {
                double averageScore = (double) score / (i + 1);
                String earlyGuess = getPoliticalAffiliationGuess(averageScore);
                if (!earlyGuess.equals("Undetermined")) {
                    System.out.println("Our early guess is that you are: " + earlyGuess);
                    guessed = true;
                    break; // Stop the survey if a guess is made
                }
            }
        }

        // Final guess if not already guessed
        if (!guessed) {
            double averageScore = (double) score / TOTAL_QUESTIONS;
            String finalGuess = getPoliticalAffiliationGuess(averageScore);
            System.out.println("Our final guess is that you are: " + finalGuess);
        }

        // Ask for actual political affiliation
        System.out.print("Please enter your actual political affiliation for our survey: ");
        String actualAffiliation = scanner.nextLine();

        System.out.println("You identified as: " + actualAffiliation);

        scanner.close();
    }

    private static boolean shouldMakeGuess(int questionNumber) {
        for (int point : GUESS_POINTS) {
            if (questionNumber == point) {
                return true;
            }
        }
        return false;
    }

    private static String getPoliticalAffiliationGuess(double averageScore) {
        if (averageScore <= LIBERAL_THRESHOLD) {
            return "Liberal";
        } else if (averageScore >= CONSERVATIVE_THRESHOLD) {
            return "Conservative";
        }
        return "Undetermined"; // Continue the survey if no strong leaning is detected
    }
}
