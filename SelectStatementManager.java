import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectStatementManager extends JFrame {
    static String select = "SELECT song.title Title, concepts.concept_name Concept, lessons.grade_level Grade, category.category_title Category \n";
    static String from = " FROM song \n";
    static String join = " JOIN belongs_to ON song.song_code = belongs_to.song_code \n" +
            " JOIN category ON belongs_to.category_code = category.category_code \n" +
            " JOIN lessons ON song.song_code = lessons.song_code \n" +
            " JOIN teaches ON lessons.lesson_plan_id = teaches.lesson_plan_ID \n" +
            " JOIN concepts ON teaches.concept_code = concepts.concept_code  \n" +
            " JOIN meets ON lessons.lesson_plan_id = meets.lesson_plan_id \n" +
            " JOIN standards ON meets.standard_key = standards.standard_key \n";
    static String where = " ";
    static String groupBy = " GROUP BY song.title;";
    //menu constructor
    public SelectStatementManager(){
        //create the main frame and sub panels
        JFrame mainFrame = new JFrame();
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        //set layout for the main frame
        BorderLayout mainLayout = new BorderLayout();
        mainFrame.setLayout(mainLayout);

        //create the top panel with the category selection menu
        //create the layout for the top panel
        FlowLayout topLayout = new FlowLayout();
        topPanel.setLayout(topLayout);

        //create the category menu & add event listener
        JLabel categoryLabel = new JLabel("Choose a category: ");
        String [] categories = new String[] {"", "Halloween", "First Day", "Game", "Vocal Exploration", "Song Fragments", "Simple Songs",
        "Vocal Improvisation", "Movement Exploration", "Songs for Form & Expression", "Steady Beat Songs & Chants", "Recorded Steady Beat Music",
        "Song Story", "Fall", "Winter", "Play Party", "Black History Month", "Hispanic Heritage Month", "Four Voices"};
        JComboBox categoryList = new JComboBox(categories);
        categoryListener categoryListener = new categoryListener();
        categoryList.addActionListener(categoryListener);


        //add the label and list to the top panel
        topPanel.add(categoryLabel);
        topPanel.add(categoryList);

        //create the concepts menu & add event listener
        JLabel conceptsLabel = new JLabel("Choose a concept: ");
        String [] concepts = new String[]{"", };

        //create the bottom panel with the reset & submit button
        //create the layout for the bottom panel
        FlowLayout bottomLayout = new FlowLayout();
        bottomPanel.setLayout(bottomLayout);

        //create the reset & submit buttons and add event listeners
        JButton reset = new JButton("Reset");
        JButton submit = new JButton("Submit");
        submitListener submitListener = new submitListener();
        submit.addActionListener(submitListener);

        //add the reset & submit buttons to the bottom (south) panel
        bottomPanel.add(reset);
        bottomPanel.add(submit);

        //add panels to their location in the border layout
        mainFrame.add(topPanel, mainLayout.NORTH);
        mainFrame.add(bottomPanel, mainLayout.SOUTH);

        //activate the frame
        mainFrame.setVisible(true);

    }

    class categoryListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            String category = (String)cb.getSelectedItem();
            if(category.equalsIgnoreCase("Halloween")) {
                where = " WHERE category.category_code = 1 ";
            }else if (category.equalsIgnoreCase("First Day")) {
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

        }
    }
    class submitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(select + from + join + where + "\n"+ groupBy);
        }
    }

}

