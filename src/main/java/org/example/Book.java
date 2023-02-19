package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // birincil anahtar olusturma stratejisini belirtmek icin kullanılan bir JPA ek açıklamasıdır.
    private Integer id;
    private String name;

    public Book(Integer id, String name){
        this.id= id;
        this.name = name;
    }

    public Book() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

/*

Bir Java projesinde, Entity modeli, veritabanındaki bir tablonun Java kodunda nasıl temsil edileceğini tanımlar.

GenerationType.IDENTITY => Birincil anahtarın veritabanındaki
otomatik artan bir kimlik sütunu tarafından oluşturulacagı anlamına
gelir.


Java projelerinde bir Repository sınıfı genellikle bir interface olarak oluşturulur,
çünkü Repository'nin veritabanı işlemlerinin gerçek uygulaması genellikle Spring Data JPA gibi bir framework tarafından sağlanır.
Repository'yi bir interface olarak tanımlayarak, uygulamanın Repository ile etkileşim kurması gereken API'yi tanımlayabilirsiniz.

Bir framework tarafından sağlanan bir temel repository interface'i olan JpaRepository gibi bir interface'i uzatarak bir Repository interface oluşturduğunuzda, çalıştığınız varlık için temel CRUD (Create, Read, Update, Delete) işlemlerine erişmeniz mümkündür,
Uygulamanın Repository ile etkileşimi için basit ve anlaşılır bir API tanımlayabilirsiniz, framework ise persistence'in karmaşıklıklarını, SQL ifadelerinin oluşturulmasını, veritabanı bağlantılarının kurulmasını ve işlemlerin yürütülmesini gibi, yerine getirir.

 */


/*
*  Spring Boot - Hibernate - PostgreSQL gerekli dependency eklendi. +
*  Resources'ın içerisine application properties dosyası eklendi. +
*  Model sınıfı oluşturuldu, Book class'ın içerisine. +
*  Repository sınıfı oluşturulacak +
*  Service sınıfı oluşturulacak +
* */