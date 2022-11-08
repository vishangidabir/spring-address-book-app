package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
    @Query(value = "SELECT * FROM address_book_data e WHERE e.first_name = :bfirst_name", nativeQuery = true)
    List<AddressBookData> findContactByName(@Param("bfirst_name") String bfirst_name);
}

