import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*String select = "SELECT song.title Title, concepts.concept_name Concept, lessons.grade_level Grade, category.category_title Category \n";
        String from = " FROM song \n";
        String join = " JOIN belongs_to ON song.song_code = belongs_to.song_code \n" +
                      " JOIN category ON belongs_to.category_code = category.category_code \n " +
                " JOIN lessons ON song.song_code = lessons.song_code \n" +
                " JOIN teaches ON lessons.lesson_plan_id = teaches.lesson_plan_ID \n" +
                " JOIN concepts ON teaches.concept_code = concepts.concept_code  \n" +
                " JOIN meets ON lessons.lesson_plan_id = meets.lesson_plan_id \n" +
                " JOIN standards ON meets.standard_key = standards.standard_key \n";
        String where = " ";
        String groupBy = " GROUP BY song.title;";

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the category: ");
        String category = kb.nextLine();

        if(category.equalsIgnoreCase("Halloween")) {
            where = " WHERE category.category_code = 1 ";
        }
        else if (category.equalsIgnoreCase("First Day")) {
            where = " WHERE category.category_code = 2";
        } else if (category.equalsIgnoreCase("Game")) {
            where = " WHERE category.category_code = 3";
        } else if (category.equalsIgnoreCase("Vocal Exploration")) {
            where = " WHERE category.category_code = 4";
        } else if (category.equalsIgnoreCase("Song Fragments")) {
            where = " WHERE category.category_code = 5";
        } else if (category.equalsIgnoreCase("Simple Songs")) {
            where = " WHERE category.category_code = 6";
        } else if (category.equalsIgnoreCase("Vocal Improvisation")) {
            where = " WHERE category.category_code = 7";
        } else if (category.equalsIgnoreCase("Movement Exploration")) {
            where = " WHERE category.category_code = 8";
        } else if (category.equalsIgnoreCase("Songs for Form & Expression")) {
            where = " WHERE category.category_code = 9";
        } else if (category.equalsIgnoreCase("Steady Beat Songs & Chants")) {
            where = " WHERE category.category_code = 10";
        } else if (category.equalsIgnoreCase("Recorded Steady Beat Music")) {
            where = " WHERE category.category_code = 11";
        } else if (category.equalsIgnoreCase("Song Story")) {
            where = " WHERE category.category_code = 12";
        } else if (category.equalsIgnoreCase("Fall")) {
            where = " WHERE category.category_code = 13";
        } else if (category.equalsIgnoreCase("Winter")) {
            where = " WHERE category.category_code = 14";
        } else if (category.equalsIgnoreCase("Play Party")) {
            where = " WHERE category.category_code = 15";
        } else if (category.equalsIgnoreCase("Black History Month")) {
            where = " WHERE category.category_code = 16";
        } else if (category.equalsIgnoreCase("Hispanic Heritage Month")) {
            where = " WHERE category.category_code = 17";
        } else if (category.equalsIgnoreCase("Four Voices")) {
            where = " WHERE category.category_code = 18";
        }

        System.out.println("Enter the concept: ");

        String fullSelectStatement = select + from + join + where + "\n"+ groupBy;
        System.out.println(fullSelectStatement);

         */

        SelectStatementManager ssm = new SelectStatementManager();
    }
}
