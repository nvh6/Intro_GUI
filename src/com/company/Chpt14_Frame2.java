package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
In Chpt14_FrameListener, we have:
        this.cancelButton.addActionListener(this);
        this.okButton.addActionListener(this);
        this.inputLine.addActionListener(this);

        //As we can see this approach of using 1 handler (Chpt14_FrameListener instance) is problematic, since in the
        //actionPerformed() we would have to do a bunch of if-else statement to determine which event source is sending
        //the action event and, therefore, act on that accordingly.


        //so in this class, we would create separate handler for each source. One for the Ok button, one for the cancel button,
        //and the other for the textfield input. Chpt14_Frame is no longer implementing ActionListener

 */
class Chpt14_Frame2 extends JFrame{

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private Container contentPane;

    private JButton cancelButton, okButton;

    private JTextField inputLine;
    private JTextArea textArea;


    Chpt14_Frame2() {
        //set up the window'd properties
        this.setTitle("My First Subclass");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        this.setResizable(false);

        //register 'Exit upon closing' as a default close operation
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //get the content pane
        this.contentPane = this.getContentPane(); //getContentPane returns JPane, which is a descendant of Container

        //set background color
        this.changeBkColor(Color.MAGENTA);

        //Create buttons:
        this.cancelButton = new JButton("CANCEL");
        this.okButton = new JButton("OK");

        //Create a Flow layout:
        FlowLayout layout1 = new FlowLayout();
        //Set that layout to the current panel:
        this.contentPane.setLayout(layout1);

        //override the default size of the buttons:
        this.okButton.setSize(80, 30);
        this.cancelButton.setSize(80, 30);

        //set up text field:
        this.inputLine = new JTextField();
        this.inputLine.setColumns(20);
        this.inputLine.setFont(new Font("Courier", Font.PLAIN, 14));

        //stage GUI objects:
            /*
            //We can add those GUI objects into JFrame
            this.add(okButton);
            this.add(inputLine);
            this.add(inputLine)
             */

        //but one thing is that JFrame cannot be added to anything else once we want it to. So it is always better to
        //add GUI objects to a container:
        this.contentPane.add(okButton);
        this.contentPane.add(cancelButton);
        this.contentPane.add(inputLine);

        //create action listener by using anonymous inner class:

        /*
            //It makes more sense to name event-listeners to the name of the JOB THEY ARE listening to, rather than to the
            //type of the event-source, because for a set of similar components that do the same type of job, one event-handler
            //can be associated with those.
         */


        //register Listeners to the event-sources
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton clickedButton = (JButton) evt.getSource();
                String text = clickedButton.getText();
                setTitle("You clicked: " + text);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton clickedButton = (JButton) evt.getSource();
                String text = clickedButton.getText();
                setTitle("You clicked: " + text);
            }
        });

        inputLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextField textEntered = (JTextField) evt.getSource();
                String text = textEntered.getText();
                setTitle("You entered: " + text);
            }
        });

    }

    private void changeBkColor(Color color) {
        this.contentPane.setBackground(color);
    }

    /*
    //Instead of using anounymous inner class for event_listeners, we can us private nest class:

    private class OkButtonHanddler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        }
    }

    private class CancelButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        }
    }

    private class TextInputHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        }
    }
     */

}
