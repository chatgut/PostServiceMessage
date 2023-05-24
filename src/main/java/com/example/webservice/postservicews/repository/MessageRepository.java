package com.example.webservice.postservicews.repository;
import com.example.webservice.postservicews.Message;
import com.example.webservice.postservicews.dto.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {



    Page<MessageDTO> findByFromEqualsIgnoreCaseAndToEqualsIgnoreCase(String from,
                                                                                     String to,
                                                                                     Pageable pageable);
    @Query("""
            {
            
            "from": { "$in":[ ?0, ?1 ] },
            "to": { "$in": [ ?1, ?0]}
            
            }
            """
    )
    Page<MessageDTO> findMessages(@Param("from") String from, @Param("to") String to, Pageable pageable);

}
