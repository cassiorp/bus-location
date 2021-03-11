package br.com.forttiori;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ItineraryServiceImplTest {

String line = "{\"idlinha\":\"5561\",\"nome\":\"FUTEBOL BEIRA-RIO\\/ARENA\",\"codigo\":\"F01-2\",\"0\":{\"lat\":\"-30.06665771357100000\",\"lng\":\"-51.23536120128900000\"},\"1\":{\"lat\":\"-30.06446271357100000\",\"lng\":\"-51.23259120128900000\"},\"2\":{\"lat\":\"-30.06430971357100000\",\"lng\":\"-51.23239220128900000\"},\"3\":{\"lat\":\"-30.06389471357100000\",\"lng\":\"-51.23198620128900000\"},\"4\":{\"lat\":\"-30.06375371357100000\",\"lng\":\"-51.23188120128900000\"},\"5\":{\"lat\":\"-30.06320471357100000\",\"lng\":\"-51.23160920128900000\"},\"6\":{\"lat\":\"-30.06145971357100000\",\"lng\":\"-51.23103120128900000\"},\"7\":{\"lat\":\"-30.06077571357100000\",\"lng\":\"-51.23086320128900000\"},\"8\":{\"lat\":\"-30.05962371357100000\",\"lng\":\"-51.23069520128900000\"},\"9\":{\"lat\":\"-30.05948271357100000\",\"lng\":\"-51.23067820128900000\"},\"10\":{\"lat\":\"-30.05869571357100000\",\"lng\":\"-51.23058320128900000\"},\"11\":{\"lat\":\"-30.05852071357100000\",\"lng\":\"-51.23056220128900000\"},\"12\":{\"lat\":\"-30.05718271357100000\",\"lng\":\"-51.23045920128900000\"},\"13\":{\"lat\":\"-30.05681671357100000\",\"lng\":\"-51.23045120128900000\"},\"14\":{\"lat\":\"-30.05637271357100000\",\"lng\":\"-51.23039520128900000\"},\"15\":{\"lat\":\"-30.05477271357100000\",\"lng\":\"-51.23021120128900000\"},\"16\":{\"lat\":\"-30.05200871357100000\",\"lng\":\"-51.22988620128900000\"},\"17\":{\"lat\":\"-30.05096371357100000\",\"lng\":\"-51.22976520128900000\"},\"18\":{\"lat\":\"-30.04793271357100000\",\"lng\":\"-51.22941520128900000\"},\"19\":{\"lat\":\"-30.04776871357100000\",\"lng\":\"-51.22939720128900000\"},\"20\":{\"lat\":\"-30.04766871357100000\",\"lng\":\"-51.22938620128900000\"},\"21\":{\"lat\":\"-30.04759071357100000\",\"lng\":\"-51.22937720128900000\"},\"22\":{\"lat\":\"-30.04746371357100000\",\"lng\":\"-51.22936320128900000\"},\"23\":{\"lat\":\"-30.04610371357100000\",\"lng\":\"-51.22920520128900000\"},\"24\":{\"lat\":\"-30.04578371357100000\",\"lng\":\"-51.22916820128900000\"},\"25\":{\"lat\":\"-30.04565471357100000\",\"lng\":\"-51.22915220128900000\"},\"26\":{\"lat\":\"-30.04454271357100000\",\"lng\":\"-51.22901720128900000\"},\"27\":{\"lat\":\"-30.04433971357100000\",\"lng\":\"-51.22899520128900000\"},\"28\":{\"lat\":\"-30.04410971357100000\",\"lng\":\"-51.22896720128900000\"},\"29\":{\"lat\":\"-30.04301971357100000\",\"lng\":\"-51.22884120128900000\"},\"30\":{\"lat\":\"-30.04184871357100000\",\"lng\":\"-51.22869420128900000\"},\"31\":{\"lat\":\"-30.04104871357100000\",\"lng\":\"-51.22861020128900000\"},\"32\":{\"lat\":\"-30.04077571357100000\",\"lng\":\"-51.22860220128900000\"},\"33\":{\"lat\":\"-30.04032371357100000\",\"lng\":\"-51.22857920128900000\"},\"34\":{\"lat\":\"-30.04028571357100000\",\"lng\":\"-51.22857720128900000\"},\"35\":{\"lat\":\"-30.03997371357100000\",\"lng\":\"-51.22855720128900000\"},\"36\":{\"lat\":\"-30.03977871357100000\",\"lng\":\"-51.22853820128900000\"},\"37\":{\"lat\":\"-30.03948171357100000\",\"lng\":\"-51.22830220128900000\"},\"38\":{\"lat\":\"-30.03932771357100000\",\"lng\":\"-51.22827320128900000\"},\"39\":{\"lat\":\"-30.03919171357100000\",\"lng\":\"-51.22819720128900000\"},\"40\":{\"lat\":\"-30.03904571357100000\",\"lng\":\"-51.22804120128900000\"},\"41\":{\"lat\":\"-30.03882371357100000\",\"lng\":\"-51.22775520128900000\"},\"42\":{\"lat\":\"-30.03879871357100000\",\"lng\":\"-51.22763520128900000\"},\"43\":{\"lat\":\"-30.03866171357100000\",\"lng\":\"-51.22736720128900000\"},\"44\":{\"lat\":\"-30.03835271357100000\",\"lng\":\"-51.22717220128900000\"},\"45\":{\"lat\":\"-30.03827971357100000\",\"lng\":\"-51.22705920128900000\"},\"46\":{\"lat\":\"-30.03812771357100000\",\"lng\":\"-51.22687920128900000\"},\"47\":{\"lat\":\"-30.03763871357100000\",\"lng\":\"-51.22642320128900000\"},\"48\":{\"lat\":\"-30.03721171357100000\",\"lng\":\"-51.22602520128900000\"},\"49\":{\"lat\":\"-30.03580471357100000\",\"lng\":\"-51.22472520128900000\"},\"50\":{\"lat\":\"-30.03547371357100000\",\"lng\":\"-51.22437020128900000\"},\"51\":{\"lat\":\"-30.03537071357100000\",\"lng\":\"-51.22421220128900000\"},\"52\":{\"lat\":\"-30.03523671357100000\",\"lng\":\"-51.22394420128900000\"},\"53\":{\"lat\":\"-30.03513771357100000\",\"lng\":\"-51.22360720128900000\"},\"54\":{\"lat\":\"-30.03509071357100000\",\"lng\":\"-51.22335220128900000\"},\"55\":{\"lat\":\"-30.03502671357100000\",\"lng\":\"-51.22270620128900000\"},\"56\":{\"lat\":\"-30.03498871357100000\",\"lng\":\"-51.22232820128900000\"},\"57\":{\"lat\":\"-30.03495671357100000\",\"lng\":\"-51.22201820128900000\"},\"58\":{\"lat\":\"-30.03487371357100000\",\"lng\":\"-51.22162520128900000\"},\"59\":{\"lat\":\"-30.03474571357100000\",\"lng\":\"-51.22133120128900000\"},\"60\":{\"lat\":\"-30.03473771357100000\",\"lng\":\"-51.22131620128900000\"},\"61\":{\"lat\":\"-30.03450871357100000\",\"lng\":\"-51.22092520128900000\"},\"62\":{\"lat\":\"-30.03432471357100000\",\"lng\":\"-51.22066720128900000\"},\"63\":{\"lat\":\"-30.03430071357100000\",\"lng\":\"-51.22061320128900000\"},\"64\":{\"lat\":\"-30.03427871357100000\",\"lng\":\"-51.22053420128900000\"},\"65\":{\"lat\":\"-30.03427271357100000\",\"lng\":\"-51.22034720128900000\"},\"66\":{\"lat\":\"-30.03449371357100000\",\"lng\":\"-51.21828520128900000\"},\"67\":{\"lat\":\"-30.03449971357100000\",\"lng\":\"-51.21797220128900000\"},\"68\":{\"lat\":\"-30.03443671357100000\",\"lng\":\"-51.21794120128900000\"},\"69\":{\"lat\":\"-30.03440771357100000\",\"lng\":\"-51.21790120128900000\"},\"70\":{\"lat\":\"-30.03257171357100000\",\"lng\":\"-51.21930520128900000\"},\"71\":{\"lat\":\"-30.03220071357100000\",\"lng\":\"-51.21944020128900000\"},\"72\":{\"lat\":\"-30.03203771357100000\",\"lng\":\"-51.21946620128900000\"},\"73\":{\"lat\":\"-30.03172971357100000\",\"lng\":\"-51.21930120128900000\"},\"74\":{\"lat\":\"-30.03146771357100000\",\"lng\":\"-51.21909920128900000\"},\"75\":{\"lat\":\"-30.03139871357100000\",\"lng\":\"-51.21907220128900000\"},\"76\":{\"lat\":\"-30.03124171357100000\",\"lng\":\"-51.21906020128900000\"},\"77\":{\"lat\":\"-30.03109771357100000\",\"lng\":\"-51.21907520128900000\"},\"78\":{\"lat\":\"-30.03107171357100000\",\"lng\":\"-51.21908020128900000\"},\"79\":{\"lat\":\"-30.03084971357100000\",\"lng\":\"-51.21912520128900000\"},\"80\":{\"lat\":\"-30.03073971357100000\",\"lng\":\"-51.21914720128900000\"},\"81\":{\"lat\":\"-30.03054071357100000\",\"lng\":\"-51.21926320128900000\"},\"82\":{\"lat\":\"-30.03047071357100000\",\"lng\":\"-51.21930420128900000\"},\"83\":{\"lat\":\"-30.02974371357100000\",\"lng\":\"-51.21936120128900000\"},\"84\":{\"lat\":\"-30.02951071357100000\",\"lng\":\"-51.21936120128900000\"},\"85\":{\"lat\":\"-30.02947771357100000\",\"lng\":\"-51.21936920128900000\"},\"86\":{\"lat\":\"-30.02939471357100000\",\"lng\":\"-51.21939020128900000\"},\"87\":{\"lat\":\"-30.02930471357100000\",\"lng\":\"-51.21943220128900000\"},\"88\":{\"lat\":\"-30.02884671357100000\",\"lng\":\"-51.21948020128900000\"},\"89\":{\"lat\":\"-30.02791971357100000\",\"lng\":\"-51.21952120128900000\"},\"90\":{\"lat\":\"-30.02710171357100000\",\"lng\":\"-51.21955820128900000\"},\"91\":{\"lat\":\"-30.02697571357100000\",\"lng\":\"-51.21954720128900000\"},\"92\":{\"lat\":\"-30.02676871357100000\",\"lng\":\"-51.21949620128900000\"},\"93\":{\"lat\":\"-30.02663771357100000\",\"lng\":\"-51.21944520128900000\"},\"94\":{\"lat\":\"-30.02659071357100000\",\"lng\":\"-51.21942220128900000\"},\"95\":{\"lat\":\"-30.02643171357100000\",\"lng\":\"-51.21934220128900000\"},\"96\":{\"lat\":\"-30.02637471357100000\",\"lng\":\"-51.21931620128900000\"},\"97\":{\"lat\":\"-30.02604871357100000\",\"lng\":\"-51.21916620128900000\"},\"98\":{\"lat\":\"-30.02597471357100000\",\"lng\":\"-51.21913120128900000\"},\"99\":{\"lat\":\"-30.02559571357100000\",\"lng\":\"-51.21895720128900000\"},\"100\":{\"lat\":\"-30.02548471357100000\",\"lng\":\"-51.21892620128900000\"},\"101\":{\"lat\":\"-30.02519671357100000\",\"lng\":\"-51.21892820128900000\"},\"102\":{\"lat\":\"-30.02497071357100000\",\"lng\":\"-51.21896920128900000\"},\"103\":{\"lat\":\"-30.02470271357100000\",\"lng\":\"-51.21915820128900000\"},\"104\":{\"lat\":\"-30.02451071357100000\",\"lng\":\"-51.21932920128900000\"},\"105\":{\"lat\":\"-30.02427671357100000\",\"lng\":\"-51.21953820128900000\"},\"106\":{\"lat\":\"-30.02349271357100000\",\"lng\":\"-51.22019820128900000\"},\"107\":{\"lat\":\"-30.02331771357100000\",\"lng\":\"-51.22028020128900000\"},\"108\":{\"lat\":\"-30.02318871357100000\",\"lng\":\"-51.22031020128900000\"},\"109\":{\"lat\":\"-30.02294071357100000\",\"lng\":\"-51.22025620128900000\"},\"110\":{\"lat\":\"-30.02276971357100000\",\"lng\":\"-51.22014220128900000\"},\"111\":{\"lat\":\"-30.02237371357100000\",\"lng\":\"-51.21973320128900000\"},\"112\":{\"lat\":\"-30.02176071357100000\",\"lng\":\"-51.21878320128900000\"},\"113\":{\"lat\":\"-30.02142571357100000\",\"lng\":\"-51.21826420128900000\"},\"114\":{\"lat\":\"-30.02124271357100000\",\"lng\":\"-51.21800420128900000\"},\"115\":{\"lat\":\"-30.02100071357100000\",\"lng\":\"-51.21765920128900000\"},\"116\":{\"lat\":\"-30.02081171357100000\",\"lng\":\"-51.21732820128900000\"},\"117\":{\"lat\":\"-30.02048971357100000\",\"lng\":\"-51.21691920128900000\"},\"118\":{\"lat\":\"-30.01998571357100000\",\"lng\":\"-51.21648420128900000\"},\"119\":{\"lat\":\"-30.01960271357100000\",\"lng\":\"-51.21620920128900000\"},\"120\":{\"lat\":\"-30.01838571357100000\",\"lng\":\"-51.21550620128900000\"},\"121\":{\"lat\":\"-30.01762171357100000\",\"lng\":\"-51.21517120128900000\"},\"122\":{\"lat\":\"-30.01633271357100000\",\"lng\":\"-51.21453820128900000\"},\"123\":{\"lat\":\"-30.01596271357100000\",\"lng\":\"-51.21431520128900000\"},\"124\":{\"lat\":\"-30.01502871357100000\",\"lng\":\"-51.21386020128900000\"},\"125\":{\"lat\":\"-30.01393671357100000\",\"lng\":\"-51.21324920128900000\"},\"126\":{\"lat\":\"-30.01193971357100000\",\"lng\":\"-51.21225920128900000\"},\"127\":{\"lat\":\"-30.01082071357100000\",\"lng\":\"-51.21172020128900000\"},\"128\":{\"lat\":\"-30.00769571357100000\",\"lng\":\"-51.21007220128900000\"},\"129\":{\"lat\":\"-30.00714571357100000\",\"lng\":\"-51.20978420128900000\"},\"130\":{\"lat\":\"-30.00620971357100000\",\"lng\":\"-51.20936120128900000\"},\"131\":{\"lat\":\"-30.00564971357100000\",\"lng\":\"-51.20914420128900000\"},\"132\":{\"lat\":\"-30.00480871357100000\",\"lng\":\"-51.20887020128900000\"},\"133\":{\"lat\":\"-30.00237871357100000\",\"lng\":\"-51.20803620128900000\"},\"134\":{\"lat\":\"-30.00240471357100000\",\"lng\":\"-51.20786320128900000\"},\"135\":{\"lat\":\"-30.00239971357100000\",\"lng\":\"-51.20775920128900000\"},\"136\":{\"lat\":\"-30.00237171357100000\",\"lng\":\"-51.20767820128900000\"},\"137\":{\"lat\":\"-30.00230571357100000\",\"lng\":\"-51.20761120128900000\"},\"138\":{\"lat\":\"-30.00229471357100000\",\"lng\":\"-51.20760020128900000\"},\"139\":{\"lat\":\"-30.00227171357100000\",\"lng\":\"-51.20757720128900000\"},\"140\":{\"lat\":\"-30.00198671357100000\",\"lng\":\"-51.20740220128900000\"},\"141\":{\"lat\":\"-30.00195771357100000\",\"lng\":\"-51.20737020128900000\"},\"142\":{\"lat\":\"-30.00181571357100000\",\"lng\":\"-51.20694020128900000\"},\"143\":{\"lat\":\"-30.00172671357100000\",\"lng\":\"-51.20690920128900000\"},\"144\":{\"lat\":\"-30.00076271357100000\",\"lng\":\"-51.20657620128900000\"},\"145\":{\"lat\":\"-29.99977171357100000\",\"lng\":\"-51.20627320128900000\"},\"146\":{\"lat\":\"-29.99967171357100000\",\"lng\":\"-51.20623020128900000\"},\"147\":{\"lat\":\"-29.99914871357100000\",\"lng\":\"-51.20612020128900000\"},\"148\":{\"lat\":\"-29.99900671357100000\",\"lng\":\"-51.20610620128900000\"},\"149\":{\"lat\":\"-29.99884071357100000\",\"lng\":\"-51.20609020128900000\"},\"150\":{\"lat\":\"-29.99879971357100000\",\"lng\":\"-51.20608620128900000\"},\"151\":{\"lat\":\"-29.99852771357100000\",\"lng\":\"-51.20602920128900000\"},\"152\":{\"lat\":\"-29.99771371357100000\",\"lng\":\"-51.20586020128900000\"},\"153\":{\"lat\":\"-29.99756371357100000\",\"lng\":\"-51.20581520128900000\"},\"154\":{\"lat\":\"-29.99743571357100000\",\"lng\":\"-51.20577620128900000\"},\"155\":{\"lat\":\"-29.99738171357100000\",\"lng\":\"-51.20576020128900000\"},\"156\":{\"lat\":\"-29.99348571357100000\",\"lng\":\"-51.20458620128900000\"},\"157\":{\"lat\":\"-29.99419871357100000\",\"lng\":\"-51.20160820128900000\"},\"158\":{\"lat\":\"-29.99318771357100000\",\"lng\":\"-51.20126420128900000\"},\"159\":{\"lat\":\"-29.99263771357100000\",\"lng\":\"-51.20107820128900000\"},\"160\":{\"lat\":\"-29.98879971357100000\",\"lng\":\"-51.19972220128900000\"},\"161\":{\"lat\":\"-29.98811171357100000\",\"lng\":\"-51.19950720128900000\"},\"162\":{\"lat\":\"-29.98790371357100000\",\"lng\":\"-51.19943420128900000\"},\"163\":{\"lat\":\"-29.98775271357100000\",\"lng\":\"-51.19938520128900000\"},\"164\":{\"lat\":\"-29.98754271357100000\",\"lng\":\"-51.19931620128900000\"},\"165\":{\"lat\":\"-29.98677571357100000\",\"lng\":\"-51.19907320128900000\"},\"166\":{\"lat\":\"-29.98635171357100000\",\"lng\":\"-51.19893420128900000\"},\"167\":{\"lat\":\"-29.98619371357100000\",\"lng\":\"-51.19888320128900000\"},\"168\":{\"lat\":\"-29.98571871357100000\",\"lng\":\"-51.19872520128900000\"},\"169\":{\"lat\":\"-29.98509371357100000\",\"lng\":\"-51.20167920128900000\"},\"170\":{\"lat\":\"-29.98304571357100000\",\"lng\":\"-51.20097220128900000\"},\"171\":{\"lat\":\"-29.98269971357100000\",\"lng\":\"-51.20085220128900000\"},\"172\":{\"lat\":\"-29.98238471357100000\",\"lng\":\"-51.20074320128900000\"},\"173\":{\"lat\":\"-29.98202571357100000\",\"lng\":\"-51.20061920128900000\"},\"174\":{\"lat\":\"-29.98180871357100000\",\"lng\":\"-51.20055520128900000\"},\"175\":{\"lat\":\"-29.98174571357100000\",\"lng\":\"-51.20053420128900000\"},\"176\":{\"lat\":\"-29.98159471357100000\",\"lng\":\"-51.20050120128900000\"},\"177\":{\"lat\":\"-29.98151871357100000\",\"lng\":\"-51.20049320128900000\"},\"178\":{\"lat\":\"-29.98134471357100000\",\"lng\":\"-51.20044420128900000\"},\"179\":{\"lat\":\"-29.98076171357100000\",\"lng\":\"-51.20028420128900000\"},\"180\":{\"lat\":\"-29.97972171357100000\",\"lng\":\"-51.19984620128900000\"},\"181\":{\"lat\":\"-29.97921271357100000\",\"lng\":\"-51.19965320128900000\"},\"182\":{\"lat\":\"-29.97860071357100000\",\"lng\":\"-51.19946120128900000\"},\"183\":{\"lat\":\"-29.97830171357100000\",\"lng\":\"-51.19937320128900000\"},\"184\":{\"lat\":\"-29.97805471357100000\",\"lng\":\"-51.19936620128900000\"},\"185\":{\"lat\":\"-29.97743071357100000\",\"lng\":\"-51.19913520128900000\"},\"186\":{\"lat\":\"-29.97665971357100000\",\"lng\":\"-51.19884920128900000\"},\"187\":{\"lat\":\"-29.97619971357100000\",\"lng\":\"-51.19864120128900000\"},\"188\":{\"lat\":\"-29.97587371357100000\",\"lng\":\"-51.19839820128900000\"},\"189\":{\"lat\":\"-29.97513371357100000\",\"lng\":\"-51.19782320128900000\"}}\n";

    @InjectMocks
    ItineraryServiceImpl itineraryService;

    @Test
    void shouldExtractId() {
        String id = this.itineraryService.extractId(line);
        System.out.println(id);
    }

    @Test
    void shouldExtratcNome() {
       String nome = this.itineraryService.extractNome(line);
        System.out.println(nome);
    }
    @Test
    void shouldExtratcCodigo() {
        String codigo = this.itineraryService.extractCodigo(line);
        Stream.of(codigo).forEach(l -> System.out.println(l));
    }

    @Test
    void shouldExtractLocations() {

        var str = this.itineraryService.extractLocations(line);


        System.out.println(str);

    }

    @Test
    void shouldExtractLocationsASList() {
        List<String> locations = this.itineraryService.locations(line);
        System.out.println(locations.get(0));
    }






}
