# 설치
bin/elasticsearch-plugin install file:///Works/github/howookjeong/elasticsearch-analysis-jamo/target/elasticsearch-analysis-jamo-7.13.2.zip

# Restful API
Request)
http://localhost:9200/_jamo?text=카카오페이

Response)
ㅋㅏㅋㅏㅇㅗㅍㅔㅇㅣ

Parameters)
text
  입력문자열
token
    JAMO("JAMO"),
    CHOSUNG("CHOSUNG"),
    JUNGSUNG("JUNGSUNG"),
    JONGSUNG("JONGSUNG"),
    KORTOENG("KORTOENG");

Request)
http://localhost:9200/_jamo?text=카카오페이&token=KORTOENG

Response)
zkzkdhvpdl