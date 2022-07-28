package com.spring.library.entity;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class LibraryTest {

    @Test
    void getId() {
        Library lib=new Library();
        lib.setId(1);
        Assertions.assertEquals(1,lib.getId());

    }


    @Test
    void getBookTitle() {
        Library lib1=new Library();
        lib1.setBookTitle("abc");
        Assertions.assertEquals("abc",lib1.getBookTitle());
    }




    @Test
    void getAuthor() {
        Library lib2=new Library();
        lib2.setAuthor("robin");
        Assertions.assertEquals("robin",lib2.getAuthor());
    }



    @Test
    void getPublisher() {
        Library lib3=new Library();
        lib3.setPublisher("news");
        Assertions.assertEquals("news",lib3.getPublisher());
    }



    @Test
    void getReleaseDate() {
        Library lib4=new Library();
        lib4.setReleaseDate("3 jun 2011");
        Assertions.assertEquals("3 jun 2011",lib4.getReleaseDate());
    }



    @Test
    void testToString() {
        Library lib6=new Library(1,"abc","robin","news","3 jan 2019");
        String Answer="Library [id=" + 1 + ", bookTitle=" + "abc" + ", Author=" + "robin" + ", Publisher=" + "news" +",releaseDate=" +"3 jan 2019"+"]";
        Assertions.assertEquals(Answer,lib6.toString());
    }
}