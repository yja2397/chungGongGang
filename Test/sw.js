/*node js 버전은 10.14.1 LTS*/
/*request 설치*/
/*cheerio 설치*/
/*urlType 설치*/
/*JSDOM 설치*/


const request = require('request'); // 모듈 가져오기. scraping
const cheerio = require('cheerio');
const urlType = require('url');
/*
const jsdom = require('jsdom');
const {JSDOM} = jsdom;

const http = require('http');
const fileSystem = require('fs');

const {window} = new JSDOM(`...`);
const {document} = new JSDOM(`...`).window;

//const window = (new JSDOM(``, {runScripts: "outside-only"})).window;

const express = require('express');
const app = express();

*/



/*주석 풀고 localhost:8888로 들어가면 Hello nodejs가 보임..*/
/*http.createServer(function (request, response) {
    response.writeHead(200, {'Content-Type' : 'text/plain'});
    response.write('Hello nodejs');
    response.end();
}).listen(8888);*/

/*Scraping*/
const scrap = (url) => request(url, (error, response, body) => {
    if (error) throw error;

    console.log(body);
});


/*SW 중심대학 Parsing. return 크롤링 배열*/
const parse = (url) => request(url, (error, response, body) => {
    if (error) throw error;

    let $ = cheerio.load(body);

    try {
        let category = ''; // 제목
        let corner = '';
        let menu = '';
        var tdArr = new Array(); // 원 데이터
        var Arr = new Array();
        var splits = new Array(); // 최종 배열

        /*가져와서 배열로 만들기*/
        $('table').each(function (index, elem) {

            category = $(this).find('thead').find('tr').find('th').text().trim();

            console.log(`${category}`);

            tdArr.push($(this).find('tbody').find('tr').find('td').text().trim()); // 원 데이터 tdArr에 넣기
            console.log(tdArr);
            tdArr = tdArr.filter(function(item){
                return item !== '\t';
            }).map(function(item){
                return item.replace(/\t/g,'');
            });

            tdArr = tdArr.filter(function(item){
                return item !== '\n';
            }).map(function(item){
                return item.replace(/\n/g,',');
            }); // 가져온 데이터의 \t와 \n를 없앰



            Arr = tdArr[0].split(','); // ,를 기준으로 tdArr를 나눔

            for(var i = 0; i < Arr.length; i++){
                if(Arr[i] != '' && Arr[i] != ' '){ // ''나 ' '는 배열에서 제외한다.
                    splits.push(Arr[i]);
                }
            }
            //console.log(splits[0]);

            /*for(var i = 0; i < 9; i++){
                var a = splits[i + 3];
                var b = a.substring(0,10);
                var c = a.substring(10,a.length);

                a.splice(3,1);
                a.splice(2,0,b);
                a.splice(3,0,c);
            }*/
        });

        /*제목 url 받아오기*/
        $("table a").each(function (idx) {
            var text = $(this).text();
            var href = $(this).attr('href');
            if(!href) return;
            var href2 = urlType.resolve(url, href);
            //console.log(text + ":" + href2);

        });

        /*table로 출력하려다 실패*/
        /*var table = document.getElementById('table');
        for(var i = 0; i < splits.length/5; i++){
            var para = document.createElement('tr');
            for(var j = 0; j < 5; j++){
                var para2 = document.createElement('td');
                var text = document.createTextNode(splits[5*i + j]);
                console.log(splits[5*i + j]);
                para2.appendChild(text);
                para.appendChild(para2);
                console.log('red');
            }
            table.appendChild(para);
        }*/

        /*table로 출력하려다 실패2*/
        /*for (var i = 0; i < splits.length / 4; i++) {
            $('#table > tbody').append('<tr>');
            for (var j = 0; j < 4; j++) {
                $('#table > tbody').append('<td>' + splits[4 * i + j] + '</td>');

                console.log((4*i + j) + ": " + splits[(4*i + j)]);
            }
            $('#table > tbody').append('</tr>');
        }*/
        console.log(splits);

        return splits;
    } catch (error) {
        console.error(error);
    }
});











/*기숙사 홈페이지 공지사항 Parsing*/
const parse2 = (url) => request(url, (error, response, body) => {
    if (error) throw error;

    let $ = cheerio.load(body);

    try {
        let category = '';
        let corner = '';
        let menu = '';
        var tdArr = new Array(); // 원 데이터
        var Arr = new Array();
        var splits = new Array(); // 최종 배열

        /*가져와서 배열로 저장.*/
        $('table').each(function (index, elem) {

            category = $(this).find('thead').find('tr').find('th').text().trim();

            console.log(`${category}`);

            tdArr.push($(this).find('tbody').find('tr').text().trim()); // 원 데이터 tdArr에 넣기

            tdArr = tdArr.filter(function(item){
                return item !== '\n';
            }).map(function(item){
                return item.replace(/\n/g,'');
            });

            tdArr = tdArr.filter(function(item){
                return item !== '\t';
            }).map(function(item){
                return item.replace(/\t/g,',');
            }); // 가져온 데이터의 \t와 \n를 없앰



            Arr = tdArr[0].split(','); // ,를 기준으로 tdArr를 나눔

            for(var i = 0; i < Arr.length; i++){
                if(Arr[i] != '' && Arr[i] != ' ' && Arr[i] != '  '){ // ''나 ' '는 배열에서 제외한다.
                    splits.push(Arr[i]);
                }
            }

        });

        /*제목 url 가져오기*/
        $("table a").each(function (idx) {
            var text = $(this).text();
            var href = $(this).attr('href');
            if(!href) return;
            var href2 = urlType.resolve(url, href);
            //console.log(text + ":" + href2);

        })

        console.log(splits);

        return splits;

    } catch (error) {
        console.error(error);
    }
});


const sw="http://wise.cnu.ac.kr/community/notice";
const dom = "https://dorm.cnu.ac.kr/_prog/_board/?code=sub05_0501&site_dvs_cd=kr&menu_dvs_cd=0501";
const eng = "https://dream.cnu.ac.kr/bbs/list.php";

parse(sw);
parse2(dom);

/*app.get('/', (req, res) => {
    res.send('Hello World!');
});
app.listen(8080, () => {
    console.log(parse(sw));
});*/

/*
var officegen = require('officegen');
var xlsx = officegen('xlsx');

request(url, function(err, res, body){
    if (err) throw err;
    var list = JSON.parse(body);
    exportToExcel(list);
    console.log(list);
});

function exportToExcel(list) {
    var sheet = xlsx.makeNewSheet();
    sheet.name = "SW중심대학사업단 공지사항";

    sheet.data[0] = [
        "번호", "제목", "작성자", "작성일", "조회"
    ];

    for(var i = 0; i <list.length; i++){
        var r = list[i];
        sheet.data[i + 1] = [r.code, r.value];

    }

    var strm = fs.createWriteStream('notice.xlsx');
    xlsx.generate(strm);
    console.log("ok");

}*/
