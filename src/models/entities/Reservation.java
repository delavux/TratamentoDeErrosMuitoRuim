package models.entities;

import models.CustomException;  // Nome ajustado

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer numeroQuarto;
    private Date checagem;
    private Date deschecagem;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
        long duracao = deschecagem.getTime() - checagem.getTime();
        return TimeUnit.DAYS.convert(duracao, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checagem, Date deschecagem) throws CustomException {
        Date now = new Date();
        if (checagem.before(now) || deschecagem.before(now)) {
            throw new CustomException("Erro na reserva: a data da reserva deve ser feita no futuro!");
        }
        if (!deschecagem.after(checagem)) {
            throw new CustomException("Erro na reserva: a saída deve ser depois do dia da checagem!");
        }

        this.checagem = checagem;
        this.deschecagem = deschecagem;
    }

    @Override
    public String toString() {
        return "Quarto "
                + numeroQuarto
                + ", Chegada: "
                + sdf.format(checagem)
                + ", Saída: "
                + sdf.format(deschecagem)
                + ", "
                + duracao()
                + " noite(s)";
    }
}
