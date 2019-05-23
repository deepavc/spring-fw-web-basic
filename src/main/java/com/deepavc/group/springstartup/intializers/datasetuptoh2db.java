package com.deepavc.group.springstartup.intializers;

import com.deepavc.group.springstartup.datamapping.Author;
import com.deepavc.group.springstartup.datamapping.Book;
import com.deepavc.group.springstartup.datamapping.Publisher;
import com.deepavc.group.springstartup.repos.AuthorRepo;
import com.deepavc.group.springstartup.repos.BookRepo;
import com.deepavc.group.springstartup.repos.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class datasetuptoh2db implements ApplicationListener<ContextRefreshedEvent> {

    AuthorRepo authorRepo;
    BookRepo bookRepo;
    PublisherRepo publisherRepo;

    public datasetuptoh2db(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        datainit();
    }

    private void datainit(){
        Set<Book> hcpub = new HashSet<>();
        Set<Book> penpub = new HashSet<>();
        Publisher p1 = new Publisher("Harper Collins","London", hcpub);
        Publisher p2 = new Publisher("Penguin Books","Michigen", penpub);
        this.publisherRepo.save(p1);
        this.publisherRepo.save(p2);

        Set<Author> authors = new HashSet<>();
        Set<Book> books = new HashSet<>();

        Author jkr = new Author("Joanne","Kathleen Rowling");

        Book b1 = new Book("Harry Potter and the Half Blood Prince","10: 0747581088 ISBN 13: 9780747581086",authors);
        Book b2 = new Book("Harry Potter and the Order of Phoenix","10: 1408855690 ISBN 13: 9781408855690",authors);
        Book b3 = new Book("Harry Potter and the Prisoner of Azkaban","10: 1408855674 ISBN 13: 9781408855676",authors);
        b1.setPublisher(p1);b2.setPublisher(p1);b3.setPublisher(p1);
        books.add(b1);books.add(b2);books.add(b3);

        hcpub.addAll(books);
        jkr.setBooks(books);
        authors.add(jkr);

        this.authorRepo.save(jkr);

        this.bookRepo.save(b1);
        this.bookRepo.save(b3);
        this.bookRepo.save(b2);


        authors.clear();
        books.clear();

        Author leechild = new Author("Lee","Child");

        Book l1 = new Book("Past Tense","10: 9780515153651; ISBN-13: 978-0515153651",authors);
        Book l2 = new Book("Killing Floor","",authors);
        Book l3 = new Book();
        l3.setName("Blue Moon");
        l3.setAuthors(authors);
        l1.setPublisher(p2);l2.setPublisher(p2);l3.setPublisher(p2);
        books.add(l1);books.add(l2);books.add(l3);
        penpub.addAll(books);
        leechild.setBooks(books);
        authors.add(leechild);

        this.authorRepo.save(leechild);

        this.bookRepo.save(l1);
        this.bookRepo.save(l2);
        this.bookRepo.save(l3);


        authors.clear();
        books.clear();

        Author davidBaldacci = new Author("David","Baldacci");

        Book d1 = new Book("Redemption","10: 9780515153651; ISBN-13: 978-0515153651",authors);
        Book d2 = new Book("Bulls Eye","",authors);


        d1.setPublisher(p2);d2.setPublisher(p2);
        books.add(d1);books.add(d2);

        penpub.addAll(books);
        davidBaldacci.setBooks(books);
        authors.add(davidBaldacci);

        this.authorRepo.save(davidBaldacci);

        this.bookRepo.save(d1);
        this.bookRepo.save(d2);


        authors.clear();
        books.clear();

        Author lisaLutz = new Author("Lisa","Lutz");
        Author davidHayward = new Author("David","Hayward");

        Book n1 = new Book("Heads You Lose");
        n1.setAuthors(authors);
        n1.setPublisher(p1);
        books.add(n1);
        hcpub.addAll(books);
        lisaLutz.setBooks(books);
        davidHayward.setBooks(books);
        authors.add(lisaLutz);authors.add(davidHayward);

        this.authorRepo.save(lisaLutz);
        this.authorRepo.save(davidHayward);

        this.bookRepo.save(n1);






    }


}
