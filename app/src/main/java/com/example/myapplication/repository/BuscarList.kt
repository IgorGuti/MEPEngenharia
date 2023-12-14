package com.example.myapplication.repository
import com.example.myapplication.model.Estado
import com.example.myapplication.model.Praia


class BuscarList {
    companion object {
        val listaDeEstados: List<Estado> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Estado("AMAPA"),
                Estado("MARANHÃO"),
                Estado("PIAUÍ"),
                Estado("CEARÁ"),
                Estado("RIO GRANDE DO NORTE"),
                Estado("PARAÍBA"),
                Estado("PERNAMBUCO"),
                Estado("ALAGOAS"),
                Estado("SERGIPE"),
                Estado("BAHIA"),
                Estado("ESPÍRITO SANTO"),
                Estado("RIO DE JANEIRO"),
                Estado("SÃO PAULO"),
                Estado("PARANÁ"),
                Estado("SANTA CATARINA"),
                Estado("RIO GRANDE DO SUL"),
                // Adicione mais itens conforme necessário
            )
        }
        val listaDePraiasAmapa: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }

        val listaDePraiasMaranhao: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }
        val listaDePraiasPiaui: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }

        val listaDePraiasCeara: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }
        val listaDePraiasRioGrandeDoNorte: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }

        val listaDePraiasParnaiba: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }
        val listaDePraiasPernambuco: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }

        val listaDePraiasAlagoas: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }
        val listaDePraiasSergipe: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }

        val listaDePraiasBahia: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("PRAIA DA BOA VIAGEM"),
                Praia("PRAIA DA PITUBA"),
                Praia("PRAIA DE AMARALINA"),
                Praia("PRAIA DE TAPUÃ"),
                Praia("PRAIA DA BOCA DO RIO"),
                Praia("PRAIA DA RIBEIRA"),
                Praia("PRAIA DE ARMAÇÃO"),
                Praia("PRAIA DE JAGUARIBE"),
                Praia("PRAIA DE ONDINA"),
                Praia("PRAIA DE SÃO TOMÉ"),
                Praia("PRAIA DO CORSÁRIO"),
                Praia("PRAIA DE PIATÃ"),
                Praia("PRAIA DE STELLA MARIS"),
                Praia("PRAIA DO CRISTO"),
                Praia("PRAIA DO FAROL DA BARRA"),
                Praia("PRAIA DO FAROL DE ITAPUÃ"),
                Praia("PRAIA DO FLAMENGO"),
                Praia("PRAIA DO PORTO DA BARRA"),
                Praia("PRAIA DOS ARTISTAS"),
                Praia("PRAIA DO JARDIM DE ALÁ"),
                Praia("PRAIA DO RIO VERMELHO"),
                Praia("PRAIA JARDIM DOS NAMORADOS"),
                Praia("PRAIA PITUAÇU"),
                Praia("PRAIA VILAS DO ATLÂNTICO"),
                Praia("PRAIA DO CRUZEIRO"),
                Praia("PRAIA DO CURUIPE"),
                Praia("PRAIA DO RIO DOS MANGUES"),
                Praia("PRAIA MUNDAÍ"),
                Praia("PRAIA TAPERAPUÃ"),
                Praia("PRAIA BOCA DA BARRA"),
                Praia("PRAIA DA AVENIDA"),
                Praia("PRAIA DA CONCHA"),
                Praia("PRAIA DE ACUÍPE"),
                Praia("PRAIA DE BATUBA"),
                Praia("PRAIA DE CANABRAVA"),
                Praia("PRAIA DE SÃO MIGUEL"),
                Praia("PRAIA DO BACK DOOR"),
                Praia("PRAIA DO CAI N'AGUA"),
                Praia("PRAIA DO CRISTO"),
                Praia("PRAIA DO CURURUPE"),
                Praia("PRAIA DO JÓIA"),
                Praia("PRAIA D DO NORTE"),
                Praia("PRAIA DO PONTUAL"),
                Praia("PRAIA DO SUL DE ILHÉUS"),
                Praia("PRAIA DO COQUEIROS"),
                Praia("PRAIA DOS MILIONÁRIOS"),
                Praia("PRAIA MAR E SOL"),
                Praia("PRAIA PONTA DO TULHA"),
                Praia("PRAIA DA GAMBOA"),
                Praia("PRAIA DE PRATAGI"),
                Praia("PRAIA DO ENCANTO"),
                Praia("PRAIA DDO ENCANTO DE GARAPUÁ"),
                Praia("PRAIA PRIMEIRA"),
                Praia("PRAIA SEGUNDA"),
                Praia("PRAIA TERCEIRA"),
                Praia("PRAIA QUARTA"),
                Praia("PRAIA DA BARRA GRANDE"),
                Praia("PRAIA DA PENHA"),
                Praia("PRAIA DA PONTA DE AREIA"),
                Praia("PRAIA DA PONTA DO MOCAMBO"),
                Praia("PRAIA DE ARATUBA"),
                Praia("PRAIA DE CACHA PREGOS"),
                Praia("PRAIA DE CATU"),
                Praia("PRAIA DE GEMELEIRA"),
                Praia("PRAIA E JIRIBATUBA"),
                Praia("PRAIA DE MANDARATIBA"),
                Praia("PRAIA DE MANGUINHOS"),
                Praia("PRAIA DE PORTO DO SANTO"),
                Praia("PRAIA DE PORTO SANTO"),
                Praia("PRAIA DE TAIRU"),
                Praia("PRAIA DO DURO"),
                Praia("PRAIA DA BURUDANGA"),
                Praia("PRAIA DA CONCHA"),
                Praia("PRAIA DA COROA"),
                Praia("PRAIA DA COSTA"),
                Praia("PRAIA DA RIBEIRA"),
                Praia("PRAIA DA TIRIRICA"),
                Praia("PRAIA DE PIRACANGA"),
                Praia("PRAIA DE SÃO JOSÉ"),
                Praia("PRAIA DO CENTRO"),
                Praia("PRAIA DO CIRIACO"),
                Praia("PRAIA DO HAVAIZINHO"),
                Praia("PRAIA DO ITACAREZINHO"),
                Praia("PRAIA DO PONTAL"),
                Praia("PRAIA DO REZENDE"),
                Praia("PRAINHA"),
                Praia("PRAIA DE PATIPE"),
                Praia("PRAIA DA COSTA"),
                Praia("PRAIA DE BARRA VELHA"),
                Praia("PRAIA DA BARRA DO ALBINO"),
                Praia("PRAIA DE ATALAIA"),
                Praia("PRAIA DO SUL E PRAIA DO NORTE"),
                Praia("PRAIA BARRA DE CANAVIEIRAS"),
                Praia("PRAIA DE SERRA GRANDE"),
                Praia("PRAIA DUNA"),
                Praia("PRAIA DITAPOROROCA"),
                Praia("PRAIA DE ACUÍPE"),
                Praia("PRAIA DA ILHA DO DESEJO"),
                Praia("PRAIA DA ILHA DE COMANDATUBA"),
                Praia("PRAIA DE TAIPU DE FORA"),
                Praia("PRAIA DA ILHA DO GOIÓ"),
                Praia("PRAIA DA ILHA DO CAMPINHO"),
                Praia("PRAIA DE BARRA GRANDE"),
                Praia("PRAIA TRÊS COQUEIROS"),
                Praia("PRAIA CASSANGE"),
                Praia("PRAIA SAQUAÍRA"),
                Praia("PRAIA ARANDIS"),
                Praia("PRAIA ALGODÕES"),
                Praia("PRAIA PIRACANGA"),
                Praia("PRAIA ILHA DE COMANDATUBA"),
                Praia("PRAIA ILHAS DE ABROLHOS"),
                Praia("PRAIA ILHA DE MARÉ"),
                )
        }

        val listaDePraiasEspiritoSanto: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("PRAIA DA BALEIA"),
                Praia("PRAIA DA COSTA"),
                Praia("PRAIA DE ITAPOÃ"),
                Praia("PRAIA DA BARRA DO JUCU"),
                Praia("PRAIA DE ITAPARICA"),
                Praia("PRAIA DE BICANGA"),
                Praia("PRAIA MOLE"),
                Praia("PRAIA DO BALNEÁRIO DE MANGUINHOS"),
                Praia("PRAIA DE CARAPEBUS"),
                Praia("PRAIA DO BALNEÁRIO DE JACARAÍPE"),
                Praia("PRAIA DO BALNEÁRIO DE NOVA ALMEIDA"),
                Praia("PRAIA ENSEADA AZUL"),
                Praia("PRAIA DA ALDEIA"),
                Praia("PRAIA DA CERCA"),
                Praia("PRAIA DÚLÉ"),
                Praia("PRAIA DA AREIA PRETA"),
                Praia("PRAIA DAS CASTANHEIRAS"),
                Praia("PRAIA DAS FONTES"),
                Praia("PRAIA DAS VIRTUDES"),
                Praia("PRAIA DE BACUTIA"),
                Praia("PRAIA DE MEAÍPE"),
                Praia("PRAIA DE PERACANGA"),
                Praia("PRAIA DE GUAIBURA"),
                Praia("PRAIA DE MUQUIÇABA"),
                Praia("PRAIA DE SANTA MÔNICA"),
                Praia("PRAIA DE SEPETIBA"),
                Praia("PRAIA DO RIACHO"),
                Praia("PRAIA DO MORRO"),
                Praia("PRAIA DO VALADÃO"),
                Praia("PRAIA DOS NAMORADOS"),
                Praia("PRAIA ILHA DAS CAIEIRAS"),
                Praia("PRAIA ILHA DO FRADE"),
                Praia("PRAIA ILHA DO BOI"),
                Praia("PRAIA DA CURVA DA JUREMA"),
                Praia("PRAIA DA DIREITA E DA ESQUERDA"),
                Praia("PRAIA DAS CASTANHEIRAS"),
                Praia("PRAIA DO CANTO"),
                Praia("PRAIA DE CAMBURI"),
                Praia("PRAIA CENTRAL"),
                Praia("PRAIA DA AREIA PRETA"),
                Praia("PRAIA DE MAIMBÁ"),
                Praia("PRAIA DE GUANABARA"),
                Praia("PRAIA DE SANTA HELENA"),
                Praia("PRAIA DE UBU"),
                Praia("PRAIA DOS CASTELHANOS"),
                Praia("PRAIA DDO BALNEÁRIO DE IRIRI"),
                Praia("PRAIA DO GURIRI"),
                Praia("PRAIA DE BARRA NOVA"),
                Praia("PRAIA DE CAMPO GRANDE"),
                Praia("PRAIA DE URUSSUQUARA"),
                Praia("PRAIA DO ABRICÓ"),
                Praia("PRAIA DO IPIRANGA"),
                Praia("PRAIA DE BARRA SECA"),
                Praia("PRAIA DE POVOAÇÃO"),
                Praia("PRAIA DE REGÊNCIA"),
                Praia("PRAIA DO CENTRO"),
                Praia("PRAIA DDOS CAÇÕES"),
                Praia("PRAIA DO SIRI"),
                Praia("PRAIA DE ACAIACA"),
                Praia("PRAIA DO CORUJÃO"),
                Praia("PRAIA DO PAU GRANDE"),
                Praia("PRAIA DOCE"),
                Praia("PRAIA MARIA NENÉM"),
                Praia("PRAIA DE ITAIPAVA"),
                Praia("PRAIA DE ITAOCA"),
                Praia("PRAIA DO RIO PRETO"),
                Praia("PRAIA GRANDE"),
                Praia("PRAIA PORTO LAMA"),
                Praia("PRAIA ENSEADA DA GRAÇAS"),
                Praia("PRAIA DA BARRA"),
                Praia("PRAIA DA BUGIA"),
                Praia("PRAIA DA GUAXINDIBA"),
                Praia("PRAIA DE ITAÚNAS"),
                Praia("PRAIA DO FAROL"),
                Praia("PRAIA DO RIACHO DOCE"),
                Praia("BARRA DO SAHY"),
                Praia("PRAIA DE FORMOSA"),
                Praia("PRAIA DE GRAMULÉ"),
                Praia("PRAIA DE PUTIRI"),
                Praia("PRAIA DE SANTA CRUZ"),
                Praia("PRAIA DO COQUEIRAL"),
                Praia("PRAIA DOS PADRES"),
                )
        }
        val listaDePraiasRioDeJaneiro: List<Praia> by lazy {
            // Inicialize a lista de praias do Rio de Janeiro aqui
            listOf(
                Praia("PRAIA DA JOATINGA"),
                Praia("PRAIA DO FLAMENGO"),
                Praia("PRAIA DE BOTAFOGO"),
                Praia("PRAIA DA URCA"),
                Praia("PRAIA VERMELHA"),
                Praia("PRAIA DO LEME"),
                Praia("PRAIA DE COPACABANA"),
                Praia("PRAIA DO DIABO"),
                Praia("PRAIA DO ARPOADOR"),
                Praia("PRAIA DE IPANEMA"),
                Praia("PRAIA DO LEBLON"),
                Praia("PRAIA DO VIDIGAL"),
                Praia("PRAIA DE SÃO CONRADO"),
                Praia("PRAIA DO PEPINO"),
                Praia("PRAIA DA BARRA DO TIJUCA"),
                Praia("PRAIA DO RECREIO"),
                Praia("PRAIA DO PONTAL DE SERNAMBETIBA"),
                Praia("PRAINHA"),
                Praia("PRAIA DO GRUMARI"),
                Praia("PRAIA BARRA DE GUARATIBA")
            )
        }
        val listaDePraiasSaoPaulo: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }

        val listaDePraiasParana: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }

        val listaDePraiasSantaCatarina: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("ARROIO DA PRAIA DAS GAIVOTAS"),
                Praia("CANAL DO LINGUADO"),
                Praia("LAGOA BRAVA"),
                Praia("LAGOA DA CONCEIÇÃO"),
                Praia("LAGOA DA FERRUGEM"),
                Praia("LAGOA DE BARRA VELHA"),
                Praia("LAGOA DO FAXINAL"),
                Praia("LAGOA DO PERI"),
                Praia("LAGOA DOS FREITAS"),
                Praia("PRAIA DA ARMAÇÃO DO PÂNTANO DO SUL"),
                Praia("PRAIA DA BARRA DA LAGOA"),
                Praia("PRAIA DA BARRA DO SUL"),
                Praia("PRAIA DA BARRA VELHA"),
                Praia("PRAIA DA BASE AÉREA"),
                Praia("PRAIA DA BEIRA MAR NORTE"),
                Praia("PRAIA DA CACHOEIRA DO BOM JESUS"),
                Praia("PRAIA DA CAIACANGAÇÚ"),
                Praia("PRAIA DA CAIEIRA"),
                Praia("PRAIA DA DANIELA"),
                Praia("PRAIA DA JOAQUINA"),
                Praia("PRAIA DA LAGOINHA"),
                Praia("PRAIA DA SAUDADE"),
                Praia("PRAIA DA SOLIDÃO"),
                Praia("PRAIA DA TAPERA"),
                Praia("PRAIA DA VIGIA"),
                Praia("BALNEÁRIO GAIVOTAS"),
                Praia("PRAIA DAS PALMEIRAS"),
                Praia("PRAIA DE BOMBAS"),
                Praia("PRAIA DE BOMBINHAS"),
                Praia("PRAIA DE CANASVIEIRAS"),
                Praia("PRAIA DE GAROPABA"),
                Praia("PRAIA DE JERERE"),
                Praia("PRAIA DE JURERE INTERNACIONA"),
                Praia("PRAIA DE LARANJEIRAS"),
                Praia("PRAIA DE MOÇAMBIQUE"),
                Praia("PRAIA DE PIÇARRAS"),
                Praia("PRAIA DE PONTA DAS CANAS"),
                Praia("PRAIA DE SAMBAQUI"),
                Praia("PRAIA DE SANTO ANTÔNIO DE LISBOA"),
                Praia("PRAIA DE SÃO MIGUEL"),
                Praia("PRAIA DE TAQUARAS"),
                Praia("PRAIA DE ZIMBROS"),
                Praia("PRAIA DO ARROIO DO SILVA"),
                Praia("PRAIA DO BALNEÁRIO"),
                Praia("PRAIA DO BALNEÁRIO CAMBORIÚ"),
                Praia("PRAIA DO BOM ABRIGO"),
                Praia("PRAIA DO CACUPÉ"),
                Praia("PRAIA DO CANTO GRANDE"),
                Praia("PRAIA DO CERRO"),
                Praia("PRAIA DO ESTALEIRINHO"),
                Praia("PRAIA DO ESTALEIRO"),
                Praia("PRAIA DO FORTE"),
                Praia("PRAIA DO ITAGUAÇU"),
                Praia("PRAIA DO JARDIM ATLÂNTICO"),
                Praia("PRAIA DO JOSÉ MENDES"),
                Praia("PRAIA DO MARISCAL"),
                Praia("PRAIA DO MATADOURO"),
                Praia("PRAIA DO MEIO"),
                Praia("PRAIA DO MOCAMBIQUE"),
                Praia("PRAIA DO MORRO DAS PEDRAS"),
                Praia("PRAIA DO MORRO DOS CONVENTOS"),
                Praia("PRAIA DO PANTANO DO SUL"),
                Praia("PRAIA DO RIBEIRÃO DA ILHA"),
                Praia("PRAIA DO RINCÃO"),
                Praia("PRAIA DO SANTINHO"),
                Praia("PRAIA DO SIRIÚ"),
                Praia("PRAIA DOS INGLESES"),
                Praia("PRAIA MOLE"),
                // Adicione mais itens conforme necessário
            )
        }
        val listaDePraiasRioGrandeDoSul: List<Praia> by lazy {
            // Inicialize a lista de praias de Santa Catarina aqui
            listOf(
                Praia("SaoPaulo"),
                Praia("SaoPaulo1"),
            )
        }
    }
}