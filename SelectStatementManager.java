import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringBufferInputStream;

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
    JComboBox categoryList;
    JComboBox conceptsList;
    JComboBox districtStndrdsList;

    JComboBox nationalStandardsList;

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

        //create the category menu
        JLabel categoryLabel = new JLabel("Choose a category: ");
        String [] categories = new String[] {"", "Halloween", "First Day", "Game", "Vocal Exploration", "Song Fragments", "Simple Songs",
        "Vocal Improvisation", "Movement Exploration", "Songs for Form & Expression", "Steady Beat Songs & Chants", "Recorded Steady Beat Music",
        "Song Story", "Fall", "Winter", "Play Party", "Black History Month", "Hispanic Heritage Month", "Four Voices"};
        categoryList = new JComboBox(categories);

        //add the label and list to the top panel
        topPanel.add(categoryLabel);
        topPanel.add(categoryList);

        //create the concepts menu
        JLabel conceptsLabel = new JLabel("Choose a concept: ");
        String [] concepts = new String[]{"", "Four Voices", "Finding Head Voice", "Improvising on a Neutral Syllable", "Improvising with Known Words",
        "Improvising Words and Melody", "Teacher Led Steady Beat", "Student Led Steady Beat", "Steady Beat in Groups of 2",
        "Steady Beat in Groups of 3", "Experiencing Form & Expression Through Movement", "Pitch echoing", "Solo singing",
        "Writing Lyrics", "Expressive Singing", "Creating Movement", "Singing simple songs", "Awareness of levels", "Awareness of weight",
        "Awareness of body", "Awareness of time", "Awareness of speed", "Awareness of locomotion", "Awareness of shapes" };
        conceptsList = new JComboBox (concepts);


        //add the concepts label and list to the top panel
        topPanel.add(conceptsLabel);
        topPanel.add(conceptsList);

        //create the standards label
        JLabel standards = new JLabel("STANDARDS");
        //create the district standards label and list
        JLabel district = new JLabel("District");
        String [] districtStandards = new String[]{"", "RH1 - Students will be able to identify what does and does not have a beat.", "RH2 - Students will be able to demonstrate a steady beat by moving and performing body percussion.",
        "RH3 - Students will be able to perform 4-beat rhythms with quarter, 2-eighths, quarter rest to a steady beat.", "PI1 - Students will be able to express high and low sounds in song and through vocal exploration, including the pitches sol and mi.",
        "PI2 - Students will be able to differentiate high and low sounds through movement.", "PI3 - Students will be able to differentiate melodies moving up and down through movement.",
        "PR1 - Students will be able to (improve their ability to) match pitches in their natural singing range.", "PR2 - Students will be able to perform songs from various genres, time periods, and cultures using their voices, classroom instruments, and/or found sounds.",
        "PR3 - Students will be able to perform rhythms and ostini on classroom instruments or found sounds using quarter notes, two eighth notes, and quarter rests.", "TI1 - Students will be able to differentiate between the four voice types (whisper, shout, talk, sing).",
        "TI2 - Students will be able to identify classroom instruments by sight and sound.", "TI3 - Students will be able to describe the materials and method of sound production for classroom instruments and found sounds.",
        "EX1 - Students will be able to use music vocabulary to describe dynamics and tempo (e.g. presto, moderato, largo, forte, piano, etc.).", "EX2 - Students will be able to demonstrate forte and piano while performing.",
        "EX3 - Students will be able to demonstrate presto, moderato, and largo while performing.", "NO1 - Students will be able to distinguish between sound and silence in simple melodies and rhythms.",
        "NO2 - Students will be able to perform four-beat rhythms from iconic notation representing quarter notes, two eighth notes, and quarter rests.", "NO3 - Students will be able to compose and notate four-beat rhythm patterns using iconic notation representing quarter notes, two eighth notes, and quarter rests.",
        "ME1 - Students will be able to sing, perform on instruments/found sounds, and/or perform movements to music in patterns of 2 and 3.", "ME2 - Students will be able to perform movements in patterns of 2 and 3 and to represent strong and weak beats.",
        "ME3 - Students will be able to represent patterns of 2 and 3 using iconic notation to represent strong and weak beats.", "FO1 - Students will be able to identify melodic and rhythmic patterns as same or different.",
        "FO2 - Students will be able to perform movement patterns that reflect AB (binary) form.", "FO3 - Students will be able to perform movement patterns that reflect ABA (ternary) form.",
        "CI1 - Students will be able to create movements that demonstrate grade-level understanding of pitch, dynamics, and tempo, and form.", "CI2 - Students will be able to improvise rhythm patterns that include quarter notes, two eighth notes, and quarter rests with classroom instruments or found sounds.",
        "CI3 - Students will be able to compose four-beat rhythms using iconic notation including quarter notes, two eighth notes, and quarter rests.", "CO1 - Students will be able to desribe the emotion expressed in songs or listening selections.",
        "CO2 - Students will be able to perform music that celebrates life events and holidays of various cultures.", "CO3 - Students will be able to perform a song with non-English lyrics."};
        districtStndrdsList = new JComboBox(districtStandards);

        //add the districtStndrdsList to the middle panel
        middlePanel.add(standards);
        middlePanel.add(district);
        middlePanel.add(districtStndrdsList);


        //create the district standards label and list
        JLabel national = new JLabel("National");
        String [] nationalStandards = new String[]{"", "MU:Cr1.1.Ka - With guidance, explore and experience music concepts (such as beat and melodic contour).", "MU:Cr1.1.Kb - With guidance, generate musical ideas (such as movements or motives).",
        "MU:Cr2.1.Ka - With guidance, demonstrate and choose favorite musical ideas.", "MU:Cr2.1.Ka - With guidance, organize personal musical ideas using iconic notation and/or recording technology.",
        "MU:Cr3.1.Ka - With guidance, apply personal, peer, and teacher feedback in refining personal musical ideas.", "MU:Cr3.2.Ka - With guidance, demonstrate a final version of personal musical ideas to peers.",
        "MU:Pr4.1.Ka - With guidance, demonstrate and state personal interest in varied musical selections.", "MU:Pr4.2.Ka - With guidance, explore and demonstrate awareness of music contrasts (such as high/low, loud/soft, same/different) in a variety of music selected for performance.",
        "MU:Pr4.3.Ka - With guidance, demonstrate awareness of expressive qualities (such as voice quality, dynamics, and tempo) that support the creators’ expressive intent.", "MU:Pr5.1.Ka - With guidance, apply personal, teacher, and peer feedback to refine performances",
        "MU:Pr5.1.Kb - With guidance, use suggested strategies in rehearsal to improve the expressive qualities of music.", "MU:Pr6.1.Ka - With guidance, perform music with expression", "MU:Pr6.1.Kb - Perform appropriately for the audience.",
        "MU:Re7.1.Ka - With guidance, list personal interests and experiences and demonstrate why they prefer some music selections over others.", "MU:Re7.2.Ka - With guidance, demonstrate how a specific music concept (such as beat or melodic direction) is used in music.",
        "MU:Re8.1.Ka - With guidance, demonstrate awareness of expressive qualities (such as dynamics and tempo) that reflect creators’/performers’ expressive intent.", "MU:Re9.1.Ka - With guidance, apply personal and expressive preferences in the evaluation of music.",
        "MU:Cn10.0.Ka - Demonstrate how interests, knowledge, and skills relate to personal choices and intent when creating, performing, and responding to music", "MU:Cn11.0.Ka - Demonstrate understanding of relationships between music and the other arts, other disciplines, varied contexts, and daily life."};
        nationalStandardsList = new JComboBox(nationalStandards);

        //add the label and the combo box to the middle panel
        middlePanel.add(national);
        middlePanel.add(nationalStandardsList);

        //create the bottom panel with the reset & submit button
        //create the layout for the bottom panel
        FlowLayout bottomLayout = new FlowLayout();
        bottomPanel.setLayout(bottomLayout);

        //create the reset & submit buttons and add event listeners
        JButton reset = new JButton("Reset");
        JButton submit = new JButton("Submit");

        submitListener submitListener = new submitListener();
        submit.addActionListener(submitListener);

        resetListener resetListener = new resetListener();
        reset.addActionListener(resetListener);

        //add the reset & submit buttons to the bottom (south) panel
        bottomPanel.add(reset);
        bottomPanel.add(submit);

        //add panels to their location in the border layout
        mainFrame.add(topPanel, mainLayout.NORTH);
        mainFrame.add(middlePanel, mainLayout.CENTER);
        mainFrame.add(bottomPanel, mainLayout.SOUTH);

        //activate the frame
        mainFrame.setVisible(true);

    }

    class submitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //get the selected item from the category ComboBox
            getCategory();
            //get the selected item from the concepts ComboBox
            getConcept();
            //get the selected item from the district standards ComboBox
            getDistrictStandard();
            //get the selected item from the national standards ComboBox
            getNationalStandard();

            //print the select statement
            System.out.println(select + from + join + where + "\n"+ groupBy);
            //reset the drop boxes to allow for a new query
            reset();
        }
    }

    public void getCategory(){
        String category = (String)categoryList.getSelectedItem();
        if(category.equalsIgnoreCase("")){
            where = "";
        }else if(category.equalsIgnoreCase("Halloween")) {
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
    public void getConcept(){
        String concept = (String)conceptsList.getSelectedItem();
        if(concept.equalsIgnoreCase("")){
            if(where.contains("W")){
                where += "";
            }else{
                where = "";
            }
        }
        else if(concept.equalsIgnoreCase("Four Voices")){
            if(where.contains("W")){
                where += " \n AND concepts.concept_code = 1";
            }else{
                where = " WHERE concepts.concept_code = 1";
            }
        }else if(concept.equalsIgnoreCase("Finding Head Voice")){
            if(where.contains("W")){
                where += " \n AND concepts.concept_code = 2";
            }else{
                where = " WHERE concepts.concept_code = 2";
            }
        }else if(concept.equalsIgnoreCase("Improvising on a Neutral Syllable")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 3";
            } else {
                where = " WHERE concepts.concept_code = 3";
            }
        }else if(concept.equalsIgnoreCase("Improvising on Known Words")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 4";
            } else {
                where = " WHERE concepts.concept_code = 4";
            }
        }else if(concept.equalsIgnoreCase("Improvising Words and Melody")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 5";
            } else {
                where = " WHERE concepts.concept_code = 5";
            }
        }else if(concept.equalsIgnoreCase("Teacher Led Steady Beat")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 6";
            } else {
                where = " WHERE concepts.concept_code = 6";
            }
        }else if(concept.equalsIgnoreCase("Student Led Steady Beat")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 7";
            } else {
                where = " WHERE concepts.concept_code = 7";
            }
        }else if(concept.equalsIgnoreCase("Steady Beat in Groups of 2")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 8";
            } else {
                where = " WHERE concepts.concept_code = 8";
            }
        }else if(concept.equalsIgnoreCase("Steady Beat in Groups of 3")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 9";
            } else {
                where = " WHERE concepts.concept_code = 9";
            }
        }else if(concept.equalsIgnoreCase("Experiencing Form & Expression Through Movement")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 10";
            } else {
                where = " WHERE concepts.concept_code = 10";
            }
        }else if(concept.equalsIgnoreCase("Pitch echoing")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 11";
            } else {
                where = " WHERE concepts.concept_code = 11";
            }
        }else if(concept.equalsIgnoreCase("Solo singing")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 12";
            } else {
                where = " WHERE concepts.concept_code = 12";
            }
        }else if(concept.equalsIgnoreCase("Writing Lyrics")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 13";
            } else {
                where = " WHERE concepts.concept_code = 13";
            }
        }else if(concept.equalsIgnoreCase("Expressive Singing")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 14";
            } else {
                where = " WHERE concepts.concept_code = 14";
            }
        }else if(concept.equalsIgnoreCase("Creating Movement")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 15";
            } else {
                where = " WHERE concepts.concept_code = 15";
            }
        }else if(concept.equalsIgnoreCase("Singing simple songs")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 16";
            } else {
                where = " WHERE concepts.concept_code = 16";
            }
        }else if(concept.equalsIgnoreCase("Awareness of levels")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 17";
            } else {
                where = " WHERE concepts.concept_code = 17";
            }
        }else if(concept.equalsIgnoreCase("Awareness of weight")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 18";
            } else {
                where = " WHERE concepts.concept_code = 18";
            }
        }else if(concept.equalsIgnoreCase("Awareness of body")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 19";
            } else {
                where = " WHERE concepts.concept_code = 19";
            }
        }else if(concept.equalsIgnoreCase("Awareness of time")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 20";
            } else {
                where = " WHERE concepts.concept_code = 20";
            }
        }else if(concept.equalsIgnoreCase("Awareness of speed")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 21";
            } else {
                where = " WHERE concepts.concept_code = 21";
            }
        }else if(concept.equalsIgnoreCase("Awareness of locomotion")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 22";
            } else {
                where = " WHERE concepts.concept_code = 22";
            }
        }else if(concept.equalsIgnoreCase("Awareness of shapes")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 23";
            } else {
                where = " WHERE concepts.concept_code = 23";
            }
        }else if(concept.equalsIgnoreCase("Listening for high/middle/low")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 24";
            } else {
                where = " WHERE concepts.concept_code = 24";
            }
        }else if(concept.equalsIgnoreCase("Awareness of space")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 25";
            } else {
                where = " WHERE concepts.concept_code = 25";
            }
        }else if(concept.equalsIgnoreCase("Awareness of others")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 26";
            } else {
                where = " WHERE concepts.concept_code = 26";
            }
        }else if(concept.equalsIgnoreCase("Performing in parts ")) {
            if (where.contains("W")) {
                where += " \n AND concepts.concept_code = 27";
            } else {
                where = " WHERE concepts.concept_code = 27";
            }
        }

    }
    public void getDistrictStandard(){
        int districtStandardIndex = districtStndrdsList.getSelectedIndex();
        if(districtStandardIndex == 1){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 20";
            }else{
                where = " WHERE standards.standard_key = 20";
            }
        } else if (districtStandardIndex == 2) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 21";
            }else {
                where = " WHERE standards.standard_key = 21";
            }
        }else if (districtStandardIndex == 3) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 22";
            }else{
                where = " WHERE standards.standard_key = 22";
            }
        }else if (districtStandardIndex == 4) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 23";
            }else{
                where = " WHERE standards.standard_key = 23";
            }
        }else if (districtStandardIndex == 5) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 24";
            }else{
                where = " WHERE standards.standard_key = 24";
            }
        }else if (districtStandardIndex == 6) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 25";
            }else{
                where = " WHERE standards.standard_key = 25";
            }
        }else if (districtStandardIndex == 7) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 26";
            }else{
                where = " WHERE standards.standard_key = 26";
            }
        }else if (districtStandardIndex == 8) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 27";
            }else{
                where = " WHERE standards.standard_key = 27";
            }
        }else if (districtStandardIndex == 9) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 28";
            }else{
                where = " WHERE standards.standard_key = 28";
            }
        }else if (districtStandardIndex == 10) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 29";
            }else{
                where = " WHERE standards.standard_key = 29";
            }
        }else if (districtStandardIndex == 11) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 30";
            }else{
                where = " WHERE standards.standard_key = 30";
            }
        }else if (districtStandardIndex == 12) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 31";
            }else{
                where = " WHERE standards.standard_key = 31";
            }
        }else if (districtStandardIndex == 13) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 32";
            }else{
                where = " WHERE standards.standard_key = 32";
            }
        }else if (districtStandardIndex == 14) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 33";
            }else{
                where = " WHERE standards.standard_key = 33";
            }
        }else if (districtStandardIndex == 15) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 34";
            }else{
                where = " WHERE standards.standard_key = 34";
            }
        }else if (districtStandardIndex == 16) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 35";
            }else{
                where = " WHERE standards.standard_key = 35";
            }
        }else if (districtStandardIndex == 17) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 36";
            }else{
                where = " WHERE standards.standard_key = 36";
            }
        }else if (districtStandardIndex == 18) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 37";
            }else{
                where = " WHERE standards.standard_key = 37";
            }
        }else if (districtStandardIndex == 19) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 38";
            }else{
                where = " WHERE standards.standard_key = 38";
            }
        }else if (districtStandardIndex == 20) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 39";
            }else{
                where = " WHERE standards.standard_key = 39";
            }
        }else if (districtStandardIndex == 21) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 40";
            }else{
                where = " WHERE standards.standard_key = 40";
            }
        }else if (districtStandardIndex == 22) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 41";
            }else{
                where = " WHERE standards.standard_key = 41";
            }
        }else if (districtStandardIndex == 23) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 42";
            }else{
                where = " WHERE standards.standard_key = 42";
            }
        }else if (districtStandardIndex == 24) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 43";
            }else{
                where = " WHERE standards.standard_key = 43";
            }
        }else if (districtStandardIndex == 25) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 44";
            }else{
                where = " WHERE standards.standard_key = 44";
            }
        }else if (districtStandardIndex == 26) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 45";
            }else{
                where = " WHERE standards.standard_key = 45";
            }
        }else if (districtStandardIndex == 27) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 46";
            }else{
                where = " WHERE standards.standard_key = 46";
            }
        }else if (districtStandardIndex == 28) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 47";
            }else{
                where = " WHERE standards.standard_key = 47";
            }
        }else if (districtStandardIndex == 29) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 48";
            }else{
                where = " WHERE standards.standard_key = 48";
            }
        }else if (districtStandardIndex == 30) {
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 49";
            }else{
                where = " WHERE standards.standard_key = 49";
            }
        }
    }

    public void getNationalStandard(){
        int nationalStandardIndex = nationalStandardsList.getSelectedIndex();
        if(nationalStandardIndex == 1){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 1";
            }else{
                where = " WHERE standards.standard_key = 1";
            }
        }else if(nationalStandardIndex == 2){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 2";
            }else{
                where = " WHERE standards.standard_key = 2";
            }
        }else if(nationalStandardIndex == 3){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 3";
            }else{
                where = " WHERE standards.standard_key = 3";
            }
        }else if(nationalStandardIndex == 4){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 4";
            }else{
                where = " WHERE standards.standard_key = 4";
            }
        }else if(nationalStandardIndex == 5){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 5";
            }else{
                where = " WHERE standards.standard_key = 5";
            }
        }else if(nationalStandardIndex == 6){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 6";
            }else{
                where = " WHERE standards.standard_key = 6";
            }
        }else if(nationalStandardIndex == 7){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 7";
            }else{
                where = " WHERE standards.standard_key = 7";
            }
        }else if(nationalStandardIndex == 8){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 8";
            }else{
                where = " WHERE standards.standard_key = 8";
            }
        }else if(nationalStandardIndex == 9){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 9";
            }else{
                where = " WHERE standards.standard_key = 9";
            }
        }else if(nationalStandardIndex == 10){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 10";
            }else{
                where = " WHERE standards.standard_key = 10";
            }
        }else if(nationalStandardIndex == 11){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 11";
            }else{
                where = " WHERE standards.standard_key = 11";
            }
        }else if(nationalStandardIndex == 12){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 12";
            }else{
                where = " WHERE standards.standard_key = 12";
            }
        }else if(nationalStandardIndex == 13){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 13";
            }else{
                where = " WHERE standards.standard_key = 13";
            }
        }else if(nationalStandardIndex == 14){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 14";
            }else{
                where = " WHERE standards.standard_key = 14";
            }
        }else if(nationalStandardIndex == 15){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 15";
            }else{
                where = " WHERE standards.standard_key = 15";
            }
        }else if(nationalStandardIndex == 16){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 16";
            }else{
                where = " WHERE standards.standard_key = 16";
            }
        }else if(nationalStandardIndex == 17){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 17";
            }else{
                where = " WHERE standards.standard_key = 17";
            }
        }else if(nationalStandardIndex == 18){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 18";
            }else{
                where = " WHERE standards.standard_key = 18";
            }
        }else if(nationalStandardIndex == 19){
            if(where.contains("W")){
                where += "\n AND standards.standard_key = 19";
            }else{
                where = " WHERE standards.standard_key = 19";
            }
        }
    }
    class resetListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //reset the drop boxes
            reset();
        }
    }

    public void reset(){
        categoryList.setSelectedIndex(0);
        conceptsList.setSelectedIndex(0);
        districtStndrdsList.setSelectedIndex(0);
        nationalStandardsList.setSelectedIndex(0);
    }

}

