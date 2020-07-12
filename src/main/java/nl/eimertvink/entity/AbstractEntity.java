package nl.eimertvink.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    @Getter @Setter
    @Id
//    @GenericGenerator(name = "generator_name",
//        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//        parameters = {
//        @Parameter(name = "sequence_name", value = "HIBERNATE_SEQUENCE") }
//    )
//    @GeneratedValue(generator = "generator_name")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_name")
//    protected int id;

    // generates sequenceName
//    @SequenceGenerator(name = "generator", sequenceName = "other", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
//    protected int id;


    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;

//    @GeneratedValue(
//        strategy= GenerationType.AUTO,
//        generator="native"
//    )
//    @GenericGenerator(
//        name = "native",
//        strategy = "native"
//    )
//    private Long id;
}
