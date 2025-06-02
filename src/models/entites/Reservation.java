package models.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer numeroQuarto;
    private Date checagem;
    private Date deschecagem;

    private static SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer numeroQuarto, Date checagem, Date deschecagem) {
        this.numeroQuarto = numeroQuarto;
        this.checagem = checagem;
        this.deschecagem = deschecagem;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public Date getChecagem() {
        return checagem;
    }

    public Date getDeschecagem() {
        return deschecagem;
    }

    public long duracao() {
        long duracao = checagem.getTime() - deschecagem.getTime();
        return TimeUnit.DAYS.convert(duracao, TimeUnit.MILLISECONDS);
    }

    public void atualizarHospedagem(Integer numeroQuarto, Date checagem, Date deschecagem) {
        this.checagem = checagem;
        this.deschecagem = deschecagem;
        this.numeroQuarto = numeroQuarto;

    }
    @Override
    public String toString(){
        return "Quarto "
                + numeroQuarto
                +", checagem: "
                + sfd.format(checagem)
                +", saida: "
                + sfd.format(deschecagem)
                +","
                + duracao()
                +" noites :";


    }
}
