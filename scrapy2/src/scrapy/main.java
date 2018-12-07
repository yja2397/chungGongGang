public class main {
    public static void main(String[] args) throws Exception{
        String URL = "http://wise.cnu.ac.kr/community/notice";
    	Crawl c = new Crawl();
    	c.setUrl(URL);
        System.out.println(c.getTable());
    }

}

