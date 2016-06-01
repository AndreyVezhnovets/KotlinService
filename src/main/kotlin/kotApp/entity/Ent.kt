package kotApp.entity


import org.hibernate.annotations.GenericGenerator

import javax.persistence.*


@Entity
@Table(name = "answers")
data class Ent(

        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
        @GenericGenerator(name = "increment", strategy = "increment")
        var id: Long = 0,

        @Column(name = "message", nullable = false, length = 50)
        var title: String = ""
)