package mb.psc.service;

import mb.psc.model.Navio;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NavioService {

    private static final String URL = "https://praticoszp21.com.br/movimentacao-de-navios/";

    public List<Navio> getMovimentacaoNavios() throws IOException {
        List<Navio> navios = new ArrayList<>();

        Document doc = Jsoup.connect(URL).get();

        // Seleciona apenas a primeira tabela da página
        Element primeiraTabela = doc.select("table").first();
        // Agora pega apenas as linhas dessa tabela
        Elements rows = primeiraTabela.select("tbody tr");

        for (Element row : rows) {
            Elements cols = row.select("td");
            if (cols.size() > 0) {
                Navio navio = new Navio();
                navio.setData(cols.get(0).text());
                navio.setHorario(cols.get(1).text());
                navio.setManobra(cols.get(2).text());
                navio.setBerco(cols.get(3).text());
                navio.setBordo(cols.get(4).text());
                navio.setNavio(cols.get(5).text());
                navio.setRota(cols.get(6).text());
                navio.setLoa(cols.get(7).text());
                navio.setBoca(cols.get(8).text());
                navio.setCalado(cols.get(9).text());
                navio.setSituacao(cols.get(10).text());

                navios.add(navio);
            }
        }
        return navios;
    }
}
