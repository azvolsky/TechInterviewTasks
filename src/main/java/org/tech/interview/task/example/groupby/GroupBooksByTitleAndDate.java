package org.tech.interview.task.example.groupby;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupBooksByTitleAndDate {

    public static class Book {

        final String author;

        final String title;
        final LocalDate publish;

        Book(String author, String title, LocalDate publish) {
            this.author = author;
            this.title = title;
            this.publish = publish;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public LocalDate getPublish() {
            return publish;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", publish=" + publish +
                    '}';
        }
    }

    static List<Book> books =
            List.of(
                    new Book("Author1", "Title1", LocalDate.parse("2020-10-01")),
                    new Book("Author1", "Title2", LocalDate.parse("2020-07-01")),
                    new Book("Author1", "Title3", LocalDate.parse("2020-09-01")),
                    new Book("Author2", "Title2", LocalDate.parse("2020-05-01")),
                    new Book("Author3", "Title3", LocalDate.parse("2020-02-01")));


    public static void showResult() {
        System.out.println("GroupBooksByTitleAndDate(latest publish date): ");
        groupByTitleAndDate().values().forEach(System.out::println);
    }

    public static Map<String, Optional<Book>> groupByTitleAndDate1() {

        Map<String, Optional<Book>> firstBook = new HashMap<>();

        for (Book book : books) {
            firstBook.putIfAbsent(book.getTitle(), Optional.of(book));
            if (firstBook.containsKey(book.title)) {
                if (firstBook.get(book.title).orElseThrow().getPublish().isAfter(book.getPublish())) {
                    firstBook.put(book.title, Optional.of(book));
                }
            }
        }
        return firstBook;
    }

    public static Map<String, Optional<Book>> groupByTitleAndDate() {
        Map<String, Optional<Book>> firstBook = books.stream()
                .collect(Collectors
                        .groupingBy(Book::getTitle, Collectors.minBy((o1, o2) -> o1.getPublish().isAfter(o2.getPublish()) ? 1 : -1)));
        return firstBook;
    }
}
