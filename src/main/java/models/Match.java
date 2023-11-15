package models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Matches")
@Data
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Player1", nullable = false)
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "Player2", nullable = false)
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "Winner", nullable = false)
    private Player winner;


    public Match(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

}