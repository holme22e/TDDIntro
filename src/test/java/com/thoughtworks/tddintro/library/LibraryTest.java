package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.joda.time.DateTime.now;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        List<String> books = new ArrayList<String>();
        String title = "Book Title";
        books.add(title);
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        List<String> books = new ArrayList<String>();

        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        verifyZeroInteractions(printStream);

    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        List<String> books = new ArrayList<String>();

        String titleOne = "Book One";
        String titleTwo = "Book Two";
        books.add(titleOne);
        books.add(titleTwo);

        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();
        verify(printStream).println("Book One");
        verify(printStream).println("Book Two");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    PrintStream printStream;
    DateTimeFormatter dateTimeFormatter;
    Library library;
    DateTime time;

    @Before
    public void setUp(){
        List<String> books = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        time = new DateTime();
    }


    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }


    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        DateTimeFormatter realDateTimeFormatter = DateTimeFormat.shortTime();
        String formattedTime = realDateTimeFormatter.print(time);

        when(dateTimeFormatter.print(time)).thenReturn("");
        library.welcome(time);

        verify(printStream).println(contains(formattedTime));
    }


    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        when(dateTimeFormatter.print(time)).thenReturn("5:00 PM");
        library.welcome(time);

        verify(printStream).println(contains("5:00 PM"));
    }
}
