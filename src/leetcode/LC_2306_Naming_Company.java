package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class LC_2306_Naming_Company {

    // Incomplete : Performance

    // Difficulty: HARD

    private static final LC_2306_Naming_Company namingCompany = new LC_2306_Naming_Company();
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) {
        executeTest(new String[]{"coffee","donuts","time","toffee"}, 6);
        executeTest(new String[]{"lack","back"}, 0);
        executeTest(new String[]{"vko","weclx","zvmr","uviw","saqckqsae","qmtnhuvei","dbecvxnf","rzqdbslryy","lcubdlpe",
                "lklqhv","zueqijqx","es","vemlotqscp","gaq","qqvnmcfb","rrzgvhgtq","r","twcwwefon","mcqauyh","tbjxnluz",
                "pemlotqscp","gipefxu","lbel","cpw","tsksova","qcej","aockrieh","mnknps","slebb","dxjkcfrl","oukuuqh",
                "zchu","dxlyaegw","ntxo","t","vgqjyqsqs","xtjuijzu","sbwi","ctxo","uleqkixvv","jlpdiyd","owrwfpxmm","ubh",
                "fbel","ehivyjl","rqnnag","zp","totd","ris","ylewubim","adjcrxniek","msiz","hohqzp","isbh","nursdl","li",
                "h","gzv","oez","sueqijqx","zgl","vfdns","opthfminwn","n","vtdcpuhbfx","bmydhsahp","pptks","i","y",
                "dmlyrme","uay","stpcos","fynvq","dpinbd","zvxmpz","v","dpzch","wkds","jxp","crzgvhgtq","u","xczgkv",
                "bityp","mgcqz","dxp","thr","o","c","adfeteaudm","zhxvzqwa","jgbltsg","ettg","ypgxg","uuenijm","flbccyoy",
                "rcvktgjf","jryiwqrxfu","f","jz","a","hcauiihqbl","jsnmlfqyb","rtdw","rfhf","dz","j","qi","mnksiyrm","nkv",
                "ecubdlpe","mfegqzfupn","ddwknaptw","cpbprbunx","zopdaetiua","ltxlk","ajed","bxxfy","lmmq","dzv","tinwjkhbn",
                "fmpwqluzwp","erdvquynmr","updjjldbx","ztdw","wrbc","gfzjelf","qpeh","meol","mnbnegzkny","ewvqbhpk","ht",
                "gtdbpymjw","zxi","ze","srbc","tjjhtr","vvmrsnxc","ft","e","kuanmcvbmp","bgazywyupu","orhtlhxu","rgmpbs",
                "gvvllz","ujecn","fevxyiioxj","zdttv","wrifva","guu","hpdjjldbx","qrclzbzy","tgwp","qfductm","uu","oklswwfvmg",
                "zxtvzsp","cunis","zfhqiwn","ejbwik","idx","neftrgzy","wy","ufhf","mz","cdkrun","tzswlbkoco","zuenijm","qtexz",
                "oevxyiioxj","iapgx","kjbwik","ecjf","mvfzr","gi","hs","pbaa","cat","wikkk","b","tfatzvdqy","oakcufbqx","l","oz",
                "fysihhmj","ubdngfcdu","ubkhly","uuzxsidnsb","cegm","xtw","lityp","yauup","zaqadeyyp","jdosncc","wh","dpnzhhfr",
                "czfpvfzcq","s","spw","srgqffdbem","jhwll","dgpalou","bfgsy","fjqibgxx","zic","pmhenjgd","hvnrzqijgc","gwavvvej",
                "nvn","trsxkruw","rywuxmh","bxarphzve","ipn","vursdl","aucnzyk","qv","oig","uabdtkl","cqbmdj","opaf","dlng","ds",
                "tdbhb","hphjnpons","zk","akds","xt","jkwwxb","ifkulp","qko","lnyyv","xbc","kphukriu","bswhj","abcrds","tvmb","ldyr",
                "fqcgus","vgwp","jvvllz","lmydhsahp","tptx","ligzk","kig","fopdaetiua","yfgwlflr","uep","dysihhmj","ktjuijzu","pvmr",
                "oyodlblld","xvf","mbzhpkxoed","pgd","p","kvf","yowijqf","hztakvx","jqcia","oursdl","frialqo","pv","pjstfiiz","fsksova",
                "zywxuhgl","gmbxojzxtv","rfu","q","hfzjelf","ywcwwefon","djzz","qwmbilqf","fbsggnj","znnta","zkc","tnllaloory","ibuz",
                "kus","ge","cqcia","wfoxwcb","ynwqvbnhyc","ls","mmtnhuvei","ajvmxedde","vukvyffk","knvnw","wukvyffk","wikvaxuh","pu",
                "htno","vnowffrdcd","m","hqkitao","uqczdmc","chxvzqwa","jktq","avg","pbgqn","qxhv","zkmkqn","nrknpciquu","mvbzqj",
                "ybcfoxuuma","jwq","egwr","tfjndoowqt","wx","xk","kcbiiha","tnsrbfgnrk","xaawv","kgqjyqsqs","bz","ap","drlqmcy",
                "rmkxwvbgib","wdosncc","uo","htvmbaakq","bwdsy","ns","lsti","nq","yuuvy","pnbrqryv","gok","x","qnjq","fhkqyuxeq",
                "qchifdoow","w","aviw","red","cvxuh","xac","fd","bslg","nv","tzfpvfzcq","ihxqfrpxa","slzjvibld","xj","cxh",
                "qwooaryqpd","vsvobxktv","ygnduvfm","bggpclnk","zlcp","bagjbno","odiitmbyd","cxjkcfrl","qdgteaok","yrkcy",
                "hqckr","ll","qioqldzmb","oxm","pbx","rvnrzqijgc","hwa","mvooal","arifva","twjxbdupm","hcbiiha","ouanmcvbmp",
                "qvgx","pcti","ebsggnj","zccgksiueq","wpoqxbzj","jhocoagamn","bpkvvseylx","rfzjelf","kxaux","kd","izycgczw",
                "txclgbthb","lovyyvho","hep","ofkulp","yllnyjgn","shrn","wmpynlasy","gvxmpz","sfegqzfupn","dg","zpxeba",
                "olflaf","co","ydsbpfydwa","wep","wcubdlpe","zgpalou","uemlotqscp","nykx","dsmxvbtaxf","gbcxxpkvts","uejn",
                "semlotqscp","eemlotqscp","rasibkqzp","cslwjr","zhdprbilxh","xjzwknquc","tzlhjpuwt","se","of","wrxv","xqckr",
                "ib","nmpwqluzwp","hndaiq","bjjxz","iyvgvqs","hbblhvtrd","ymgz","wnozjo","gxuinb","nofzakry","jztwgdf",
                "ymnpdocdxy","jtmcytbgb","hv","znyyv","sjuunbl","uzycgczw","ummepwe","yryzximrh","urwgvm","yaawv","ydmfeekuw",
                "dviyc","xal","gwrwfpxmm","pdl","zvgx","hmygbqzigp","gkd","wzfqxotc","yamegkfig","nkjcjtjr","tddpwbt","hdzpgo",
                "lfgsy","nvmb","tqckr","jkv","phpiwbcg","jqnomtu","ksiz","jcauiihqbl","yzyutjcoh","egtiyglu","wuxatlq","xamegkfig",
                "qzqdbslryy","anbn","diisvhfpj","qaiujw","rvdx","sc","qgudi","udpi","ijjhtr","ilzjvibld","vj","anllaloory","et",
                "zjnh","jec","bpdjjldbx","kchaozj","npnlzxv","qlebb","wd","sbcclnab","sj","wt","kvgx","utgkypjby","bygods","uy","sdvecyzy","kptx","gdsts","wqksxzbyd","egbbhwhgi","apqanzxk","noucxk","eocxue","fdgozm","spzqksumhs","pqwlldwgo","dpeiunz","jkymlvhs","xgcqz","aedtpsk","mgazywyupu","brliv","unqne","sedtpsk","qew","ddqlbzvfv","bzqdbslryy","re","mwb","ay","usy","hegm","oykablpe","qic","nhivyjl","dtdcpuhbfx","aljbx","cgbbhwhgi","atouinpvoo","wbecvxnf","adl","dlqmel","uvlqwn","skwmdgm","gus","mcwsezhqnf","ynnta","aotpqeh","cevmw","qlommmg","cmcgfiz","mabdtkl","ucl","hdgteaok","snitnrmkh","aryiwqrxfu","zlsxxddr","ptsw","sq","lxocryokg","kcyd","ojbdttfdh","edyr","ocksmkjp","rhqfphpkm","ieqnbvzzvx","mg","aw","zooxldkj","vdenu","rdjcrxniek","beh","erkcy","kp","gpinbd","bvugfhs","agozjkhx","qcmbd","vlhdsavrc","keey","tfgwlflr","ac","jrduo","npnsbht","jsheka","nzgjzxx","eczktnmggu","vqh","halbbzawh","bndaiq","dursdl","vx","oeftrgzy","jggtwnmdq","eqczdmc","bpgrju","bwvqbhpk","oorcn","iqauy","sydomm","gjbvdqfchm","hnh","krydot","bjanw","oxv","vpeiunz","oikon","owooaryqpd","jsa","jbryy","ezgosgjact","sqh","qh","osdfil","xe","wgypd","fggcwlw","kzfpvfzcq","vo","xf","qagjbno","vospfwm","lpygdtpo","vm","sausrlm","jwsfflagv","mpzch","qapmkht","icfbcdkc","pg","luoaikoh","tsdfil","tt","xbsggnj","im","ifviqhy","pfatzvdqy","fdfimmeo","xsbh","mevxyiioxj","wok","puhgdyoiar","rwu","srzgvhgtq","qhr","pgqjyqsqs","nnugxuqgv","ryodlblld","qf","nr","wgqvwdxuyf","lkqb","llewubim","keflrudln","cpqanzxk","ipgefzxuq","qgypd","mysaju","wkmkqn","wdrpaor","rr","eqcia","ptjrthzoq","ybgq","spxeba","xyicvwlv","xoyszkymav","kr","nmmepwe","psvobxktv","pfznps","skitqsrg",
                "pmygbqzigp","qyufnzs"}, -1);
    }

    private static void executeTest(String[] ideas, long expectedOutput) {
        long output = namingCompany.distinctNames(ideas);
        int testNumber = atomicCounter.getAndIncrement();
        if (output != expectedOutput) {
            System.out.printf("FAILED [%s] : expected %s, but got %s \n", testNumber, expectedOutput, output);
        } else {
            System.out.printf("PASSED [%s] \n", testNumber);
        }
    }

    public long distinctNames(String[] ideas) {
        List<String> allNames = Arrays.asList(ideas);
        Set<String> validNames = new HashSet<>();

        for (String ideaA : ideas) {
            for (String ideaB : ideas) {
                if (ideaA.equals(ideaB)) {
                    continue;
                }
                char firstA = ideaA.charAt(0);
                char firstB = ideaB.charAt(0);
                String newA = firstB + ideaA.substring(1);
                String newB = firstA + ideaB.substring(1);

                if (!allNames.contains(newA) && !allNames.contains(newB)) {
                    String newName = newA + " " + newB;
                    validNames.add(newName);
                }
            }
        }

        return validNames.size();
    }

}
