##################################################
# 데이터베이스 생성
##################################################
DROP DATABASE IF EXISTS fitness;

CREATE DATABASE fitness CHARACTER SET=utf8mb4;

USE fitness;


##################################################
# 테이블 생성
##################################################
## video(영상) 테이블
DROP TABLE IF EXISTS video;
CREATE TABLE video (
id VARCHAR(500) PRIMARY KEY,
videoid VARCHAR(100) NOT NULL UNIQUE,
url VARCHAR(750) NOT NULL UNIQUE,
title VARCHAR(100) NOT NULL,
channel_name VARCHAR(100) NOT NULL,
part VARCHAR(20) NOT NULL,
level INT NOT NULL,
description VARCHAR(10000),
thumbnail VARCHAR(750) NOT NULL,
upload_date DATETIME NOT NULL,
view_cnt INT NOT NULL DEFAULT 0 ,
count_heart INT NOT NULL DEFAULT 0
);
DESC video;

## user(사용자) 테이블
DROP TABLE IF EXISTS user;
CREATE TABLE user (
id VARCHAR(500) PRIMARY KEY,
userid VARCHAR(30) NOT NULL UNIQUE,
pw VARCHAR(64) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
interest1 VARCHAR(20),
interest2 VARCHAR(20),
quote VARCHAR(100),
privacy VARCHAR(10) NOT NULL DEFAULT "N",
mounted VARCHAR(10) NOT NULL DEFAULT "N"
);
DESC user;

## heart(찜) 테이블 
DROP TABLE IF EXISTS heart;
CREATE TABLE heart (
id VARCHAR(500) PRIMARY KEY,
u_id VARCHAR(500) NOT NULL,
v_id VARCHAR(500) NOT NULL,
heart_date DATETIME NOT NULL
);
DESC heart;

## comment(댓글) 테이블 
DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
id VARCHAR(500) PRIMARY KEY,
u_id VARCHAR(500) NOT NULL,
v_id VARCHAR(500) NOT NULL,
reg_date VARCHAR(30) NOT NULL,
content VARCHAR(10000) NOT NULL
);
DESC comment;

## friend(친구 관계) 테이블
DROP TABLE IF EXISTS friend;
CREATE TABLE friend (
id VARCHAR(500) PRIMARY KEY,
u_id1 VARCHAR(500) NOT NULL,
u_id2 VARCHAR(500) NOT NULL,
join_date VARCHAR(30) NOT NULL
);
DESC friend;

## performance(운동 기록) 테이블
DROP TABLE IF EXISTS performance;
CREATE TABLE performance (
id VARCHAR(500) PRIMARY KEY,
u_id VARCHAR(500) NOT NULL,
calorie INT NOT NULL DEFAULT 0,
heart_rate INT NOT NULL,
bmi INT NOT NULL,
minute INT NOT NULL DEFAULT 0,
fit_date DATETIME NOT NULL
);
DESC performance;


##################################################
# 데이터 추가
##################################################
## video(영상) 테이블
INSERT INTO video VALUES ("v2205221412", "7NPwSCjqka0", "https://www.youtube.com/embed/7NPwSCjqka0", "운동 다시 시작하시게요? 헬스 초,중급 상체 루틴 가이드", "김강민_Kim Kang min", "upper", "1", "안녕하세요 담당pd 입니다 헬린이들을 위한 그대로 따라하기 좋은 상체 루틴을 가져왔습니다 다음영상은 더 유익한 영상으로 찾아뵙겠습니다", "https://i.ytimg.com/vi/7NPwSCjqka0/maxresdefault.jpg", "2020-09-16", 0, 0);
INSERT INTO video VALUES ("v2205221413", "HCnDDAMDKps", "https://www.youtube.com/embed/HCnDDAMDKps", "어깨후면.. 저는 이렇게 합니다..", "김종국 GYM JONG KOOK", "upper", "2", "많은 분들이 어깨 운동에 관심이 많으시고 그만큼 고민도 많으신것 같습니다. (제가 그랬어서 ㅎ) 정말 키우고 싶지만 또 생각만큼 잘 안커지는 어깨! 오랜시간 이짓 저짓(?) 다 해보고 찾은 몇가지 현실적인 운동법 여러분들과 나누려고 준비 했습니다.", "https://i.ytimg.com/vi/HCnDDAMDKps/maxresdefault.jpg", "2022-05-12", 0, 0);
INSERT INTO video VALUES ("v2205221414", "Hx8Lc_0hUaI", "https://www.youtube.com/embed/Hx8Lc_0hUaI", "운동할 시간이 없다는 사람에게 보여주세요... 제발", "김종국 GYM JONG KOOK", "upper", "3", "정말 생업에 종사하시면서 시간이 없으신 분들도 있으시겠지만, 분명히 있는 시간을 못 찾으시는(?) 분들이 많이 있으셔서 오늘 영상을 준비했습니다! 평소에 숨어있던 여러분들의 시간! 제가 찾아드리겠습니다!", "https://i.ytimg.com/vi/Hx8Lc_0hUaI/maxresdefault.jpg", "2021-11-04", 0, 0);
INSERT INTO video VALUES ("v2205221415", "u5OgcZdNbMo", "https://www.youtube.com/embed/u5OgcZdNbMo", "저는 '하체'식주의자 입니다..", "김종국 GYM JONG KOOK", "lower", "1", "이번 영상은 남녀노소 구분 없이 백번 천 번 강조해도 모자람이 없는 하체 운동입니다! 개인적으로는 다른 부위에 비해 약하다 보니 더욱 즐겁고 만들어가는 재미가 있어서 저의 최애 운동입니다! 좋은 건 나눠야죠~ ㅎ", "https://i.ytimg.com/vi/u5OgcZdNbMo/maxresdefault.jpg", "2021-08-26", 0, 0);
INSERT INTO video VALUES ("v2205221416", "ml6cT4AZdqI", "https://www.youtube.com/embed/ml6cT4AZdqI", "30-Minute HIIT Cardio Workout with Warm Up - No Equipment at Home | SELF", "SELF", "whole", "2", "In this high intensity cardio bodyweight workout from trainer Lita Lewis, you’ll spike your heart rate with high-knees, fast feet, and star jumps; plus work your core and lower body with jumping lunges and planks - at home! No equipment needed!", "https://i.ytimg.com/vi/ml6cT4AZdqI/maxresdefault.jpg", "2018-05-22", 0, 0);
INSERT INTO video VALUES ("v2205221417", "UoC_O3HzsH0", "https://www.youtube.com/embed/UoC_O3HzsH0", "10 MIN BODYWEIGHT WORKOUT (NO EQUIPMENT HOME WORKOUT!)", "Fraser Wilson", "whole", "3", "Get ready for one of the best Home Workouts of your LIFE! Let's do this! A full body workout that you can do whenever and wherever you like... even before bed! You don't need any equipment or weight.", "https://i.ytimg.com/vi/UoC_O3HzsH0/maxresdefault.jpg", "2018-11-29", 0, 0);
INSERT INTO video VALUES ("v2205221418", "dwMMn2FdBFQ", "https://www.youtube.com/embed/dwMMn2FdBFQ", "How Exercise Makes you Smarter and a Better Student", "Med School Insiders", "general", "1", "Everyone knows the health benefits of regular exercise, but it will also help improve your grades. Regular exercise will make you a better student by teaching you to be comfortable with being uncomfortable. Any form of regular exercise (meaning not necessarily at elite or competitive levels) will provide you tremendous benefits in studying, discipline, and your studies overall.", "https://i.ytimg.com/vi/dwMMn2FdBFQ/maxresdefault.jpg", "2017-01-22", 0, 0);
INSERT INTO video VALUES ("v2205221419", "37UhELFvPec", "https://www.youtube.com/embed/37UhELFvPec", "Power of Fitness | Vincent Lam | TEDxRanneySchool", "TEDx Talks", "general", "2", "Why exercise is an important part of a healthy lifestyle. Vincent Lam has had a passion for fitness for as long as he can remember. His goal is to help people restore, maintain, and promote quality of life and optimal physical function.", "https://i.ytimg.com/vi/37UhELFvPec/maxresdefault.jpg", "2018-05-10", 0, 0);
INSERT INTO video VALUES ("v2205191412", "gMaB-fG4u4g", "https://www.youtube.com/embed/gMaB-fG4u4g", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "ThankyouBUBU", "whole", "4", "파이팅!", "http://i.ytimg.com/vi/gMaB-fG4u4g/maxresdefault.jpg", "2021-05-24", 0, 0);
INSERT INTO video VALUES ("v2205191414", "7TLk7pscICk", "https://www.youtube.com/embed/7TLk7pscICk", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "SomiFit", "upper", "2", "5분의 기적^^", "http://i.ytimg.com/vi/7TLk7pscICk/maxresdefault.jpg", "2018-02-18", 0, 0);
INSERT INTO video VALUES ("v2205191501", "K6FWSsHITc8", "https://www.youtube.com/embed/K6FWSsHITc8", "Fire Up Your Core and Glutes With This 30-Minute HIIT Challenge | POPSUGAR FITNESS", "POPSUGAR Fitness", "whole", "2", "Get ready to work out with fitness trainer Chelsey Cioli, who will be leading this 30-minute HIIT workout with class members Paris Nicole and Poofy Moffitino! This advanced routine will start with a warmup that includes hip circles, hamstring stretches, and much more.", "http://i.ytimg.com/vi/K6FWSsHITc8/maxresdefault.jpg", "2022-05-23", 0, 0);
INSERT INTO video VALUES ("v2205191502", "ElmG9ebi_xI", "https://www.youtube.com/embed/ElmG9ebi_xI", "Build Your Strength and Stamina With This 30-Minute HIIT Challenge | POPSUGAR FITNESS", "POPSUGAR Fitness", "lower", "2", "Get ready to work out with fitness trainer Natalie White, who will be leading this 30-minute HIIT workout joined by Alexis Turner and Khetanya Henderson! In this routine, you'll start with a warmup and work your way through intervals of high knees, jumping jacks, three-count squat jumps, and many more heart-pumping exercises.", "http://i.ytimg.com/vi/ElmG9ebi_xI/maxresdefault.jpg", "2022-05-21", 0, 0);
INSERT INTO video VALUES ("v2205191503", "FY7I84myQJM", "https://www.youtube.com/embed/FY7I84myQJM", "Find Your Inner Strength With This 15-Minute Boxing-Inspired Workout", "POPSUGAR Fitness", "upper", "4", "Feel the beat and turn up the heat while learning some new dance and boxing movements with professional dancer Meagan Kong. This effective routine combines the fun of dance cardio with the empowering movements of a boxing class. By the end of this 15-minute workout, you'll feel like you can take on any challenge that the day brings your way!", "http://i.ytimg.com/vi/FY7I84myQJM/maxresdefault.jpg", "2022-05-18", 0, 0);
INSERT INTO video VALUES ("v2205191505", "7KSNmziMqog", "https://www.youtube.com/embed/7KSNmziMqog", "10 MINUTE FAT BURNING MORNING ROUTINE | Do this every day | Rowan Row", "Rowan Row", "upper", "5", "Get shredded without a gym by doing this routine every morning. It only takes 10 mins of your time. Make sure you execute the movement correctly and stick to the whole circuit for the best results. Please comment below if you have any questions at all.", "http://i.ytimg.com/vi/7KSNmziMqog/maxresdefault.jpg", "2020-07-03", 0, 0);
INSERT INTO video VALUES ("v2205191504", "IT94xC35u6k", "https://www.youtube.com/embed/IT94xC35u6k", "20 min Fat Burning Workout for TOTAL BEGINNERS (Achievable, No Equipment)", "MadFit", "upper", "4", "a 20 min fat burning, full body workout you can do at home without any equipment! A workout designed for TOTAL BEGINNERS! Wether you are just getting into fitness, or are getting back in the fitness game... this one is for you.", "http://i.ytimg.com/vi/IT94xC35u6k/maxresdefault.jpg", "2022-02-08", 0, 0);
INSERT INTO video VALUES ("v2205191506", "SbJXu898mLM", "https://www.youtube.com/embed/SbJXu898mLM", "10 MIN ABS AND OBLIQUES WORKOUT | Rowan Row", "Rowan Row", "whole", "4", "Here is 10 min abs and obliques workout to shape your tummy just on point. Sort of workout that can be performed anywhere as you don’t need any gym equipment at all. Give it a go and please do let me know how you find it. Enjoy :)", "http://i.ytimg.com/vi/SbJXu898mLM/maxresdefault.jpg", "2022-05-09", 0, 0);
INSERT INTO video VALUES ("v2205191508", "oM0aKxVGdBc", "https://www.youtube.com/embed/oM0aKxVGdBc", "LEG WORKOUT | No Equipment | Rowan Row ft Emma Miller", "Rowan Row", "lower", "3", "A leg workout with no equipment with the one and only Emma Miller. Hope you guys enjoy this leg workout that you can do it at home or anywhere really because you don’t  need any gym equipment at all. Please do comment below if you have any questions. Enjoy :)", "http://i.ytimg.com/vi/oM0aKxVGdBc/maxresdefault.jpg", "2021-12-05", 0, 0);
INSERT INTO video VALUES ("v2205191507", "QLJ_Dhxg8sw", "https://www.youtube.com/embed/QLJ_Dhxg8sw", "LOWER BODY & CORE | Follow Along | Rowan Row", "Rowan Row", "lower", "3", "Super effective upper body and core workout without equipment that can be performed at home or anywhere you go. If you want to shape them legs and abs then give this a go and let me know how it goes by commenting below. Enjoy :)", "http://i.ytimg.com/vi/QLJ_Dhxg8sw/maxresdefault.jpg", "2021-10-27", 0, 0);
INSERT INTO video VALUES ("v2205191509", "bddn07uok4U", "https://www.youtube.com/embed/bddn07uok4U", "PUSH UPS FOR BEGINNERS | Follow Along | Rowan Row", "Rowan Row", "whole", "1", "You find it hard to do push ups, here’s exactly what you need to get you started. I’ve created this push-up workout for all the beginners out there to get you stronger and of course help you achieving your goals. Give it a go and let me know how you find it by commenting below. Enjoy :)", "http://i.ytimg.com/vi/bddn07uok4U/maxresdefault.jpg", "2022-02-14", 0, 0);
INSERT INTO video VALUES ("v2205191510", "JIQUbPqfVV4", "https://www.youtube.com/embed/JIQUbPqfVV4", "5 MIN LOWER BODY WORKOUT (NO REST TABATA) // No Equipment & Fat Burning | 5분 하체지방 폭파 타바타 운동", "Allblanc TV", "lower", "5", "Happy New Year. This is Louis from Allblanc TV. Today's workout is 5 minute lower body tabata without rest !! It is basically home-training routine (no equipment needed) so you can do everywhere, at home or gym.", "http://i.ytimg.com/vi/JIQUbPqfVV4/maxresdefault.jpg", "2020-01-03", 0, 0);
INSERT INTO video VALUES ("v2205191511", "GxGBnYF1Pnk", "https://www.youtube.com/embed/GxGBnYF1Pnk", "No Equipment Lower Body & Shoulder", "Jordan Yeoh Fitness", "lower", "4", "Prepare a towel, get physically and mentally ready! Hit Play, and GO! Your body will thank you!", "http://i.ytimg.com/vi/GxGBnYF1Pnk/maxresdefault.jpg", "2020-09-19", 0, 0);
INSERT INTO video VALUES ("v2205191512", "t5VpxKTJ6gY", "https://www.youtube.com/embed/t5VpxKTJ6gY", "No Gym Lower Body 10min Workoutㅣ하체운동 끝판왕, 10분 홈트레이닝", "Allblanc TV", "lower", "4", "Lower body workout is always important to increase your stamina for a continuous exercise plan. Here is 10 minute perfect workout routine you can follow at home without equipment. No excuse ! Let's get started !!", "http://i.ytimg.com/vi/t5VpxKTJ6gY/maxresdefault.jpg", "2020-11-15", 0, 0);
INSERT INTO video VALUES ("v2205191513", "hLKh7DXOiHk", "https://www.youtube.com/embed/hLKh7DXOiHk", "15 MINUTE Lower Body Workout at Home with Resistance Bands", "adidas Runtastic", "lower", "2", "Try this lower body workout at home with a resistance bands today! All you need is 15 minutes, some space at home and a resistance band to strengthen and tighten up your lower body.", "http://i.ytimg.com/vi/hLKh7DXOiHk/maxresdefault.jpg", "2020-11-13", 0, 0);
INSERT INTO video VALUES ("v2205191514", "4dH528sDhGA", "https://www.youtube.com/embed/4dH528sDhGA", "맙소사. 이번 4분 전신 타바타 꼭 하세요 | MUST DO TOTAL BODY 4MIN TABATA", "Allblanc TV", "whole", "5", "Hello guys, it's allblanc TV today we prepared TOTAL BODY 4min workout all together. Since workout gets easily bored and sometimes it's too hard to keep up, we prepare various background and different routine and model for you guys to keep it up. Then Let's make it happen today.", "http://i.ytimg.com/vi/4dH528sDhGA/maxresdefault.jpg", "2019-04-29", 0, 0);
INSERT INTO video VALUES ("v2205191515", "eqJjmmR5Xj0", "https://www.youtube.com/embed/eqJjmmR5Xj0", "15 Minute LEG Workout - Fitness Series With Romee Strijd", "Romee Strijd", "lower", "2", "15 Minute LEG Workout - Fitness Series With Romee Strijd", "http://i.ytimg.com/vi/eqJjmmR5Xj0/maxresdefault.jpg", "2019-04-17", 0, 0);
INSERT INTO video VALUES ("v2205191516", "BHY0FxzoKZE", "https://www.youtube.com/embed/BHY0FxzoKZE", "Wendy Suzuki: The brain-changing benefits of exercise | TED", "TED", "general", "3", "What's the most transformative thing that you can do for your brain today? Exercise! says neuroscientist Wendy Suzuki. Get inspired to go to the gym as Suzuki discusses the science of how working out boosts your mood and memory -- and protects your brain against neurodegenerative diseases like Alzheimer's.", "http://i.ytimg.com/vi/BHY0FxzoKZE/maxresdefault.jpg", "2018-03-21", 0, 0);
INSERT INTO video VALUES ("v2205191517", "8so1WZ4j1oQ", "https://www.youtube.com/embed/8so1WZ4j1oQ", "The Exercise Happiness Paradox | Chris Wharton | TEDxSevenoaks", "TEDx Talks", "general", "4", "How can you manipulate your brain to achieve greater levels of happiness? Can you be so inspired that your daily exercises bring you joy and increase your self-esteem? By practicing the four key strategies given in this TEDx talk, we can all achieve greater levels of energy, mood and overall health along with positive long-term changes in our physiques.", "http://i.ytimg.com/vi/8so1WZ4j1oQ/maxresdefault.jpg", "2021-10-01", 0, 0);
INSERT INTO video VALUES ("v2205191518", "wWGulLAa0O0", "https://www.youtube.com/embed/wWGulLAa0O0", "What happens inside your body when you exercise?", "British Heart Foundation", "general", "2", "We all know exercise is good for us, but what actually happens inside your body when you get active? Watch to find out, and learn more about the benefits of exercise for your heart.", "http://i.ytimg.com/vi/wWGulLAa0O0/maxresdefault.jpg", "2017-04-03", 0, 0);
INSERT INTO video VALUES ("v2205191519", "Z63w5PefxTQ", "https://www.youtube.com/embed/Z63w5PefxTQ", "DON'T QUIT - Motivational Workout Speech 2020", "AlexKaltsMotivation", "general", "5", "Follow AlexKaltsMotivation", "http://i.ytimg.com/vi/Z63w5PefxTQ/maxresdefault.jpg", "2020-02-13", 0, 0);
INSERT INTO video VALUES ("v2205191520", "kwkqjMSuDog", "https://www.youtube.com/embed/kwkqjMSuDog", "WHEN YOU FEEL LIKE QUITTING - Best Motivational Speech 2022", "AlexKaltsMotivation", "general", "4", "Follow AlexKaltsMotivation", "http://i.ytimg.com/vi/kwkqjMSuDog/maxresdefault.jpg", "2022-05-12", 0, 0);
INSERT INTO video VALUES ("v2205191521", "JV8mIfjwPeM", "https://www.youtube.com/embed/JV8mIfjwPeM", "THE 4 MINUTE SPEECH THAT WILL CHANGE YOUR LIFE | David Goggins (2021)", "Fuel The Mind", "general", "3", "In this video, David Goggins mentions that self-discipline is everything. It's all on you! The self part is what's big. Do not allow yourself to become civilized. Be uncommon amongst uncommon people. We have 2 voices in our minds.", "http://i.ytimg.com/vi/JV8mIfjwPeM/maxresdefault.jpg", "2021-02-15", 0, 0);
INSERT INTO video VALUES ("v2205191522", "01yaGpaoVSU", "https://www.youtube.com/embed/01yaGpaoVSU", "Legendary Upper Body Home Workout (ft. 10min Tabata)", "Allblanc TV", "upper", "3", "Here are Legendary Upper Body Workout you can do at home. This workout routine consists of various exercises to stimulate chest, back, shoulder, and arms. If you want to have toned upper body shape, don't miss this workout !!", "https://i.ytimg.com/vi/01yaGpaoVSU/maxresdefault.jpg", "2020-11-04", 0, 0);
INSERT INTO video VALUES ("v2205191523", "gnTzk1yUHB4", "https://www.youtube.com/embed/gnTzk1yUHB4", "Complete 15 Min Full Body Workout | No Equipment", "THENX", "whole", "3", "Follow along with Chris Heria as he shows you a Complete 15 Min Full Body Workout without the need of any equipment. Get a super effect full body workout that hits every muscle in your body using different exercises to build strength and burn fat in just 15 minutes.", "https://i.ytimg.com/vi/gnTzk1yUHB4/maxresdefault.jpg", "2022-02-28", 0, 0);
SELECT * FROM video;

## user(사용자) 테이블
INSERT INTO user VALUES ("u2205201218", "hyun", "19469c494732522546ec5705f49c5b734bfc1e960e6532da6a40471b527eeead", "hyun@gmail.com", "upper", "whole", "LETS GET IT", "Y", "N");
INSERT INTO user VALUES ("u2205201219", "tina", "d148bfa1bbe1ce4635f6bc654de582708d6efff9815b4ed28bd49b688830d194", "tina@gmail.com", "lower", "whole", "START 220523 MON", "N", "Y");
INSERT INTO user VALUES ("u2205201220", "park", "4d3971de62245c94cd3dd8d4d3a72b8ff527d902832eedc8529a9717a969f1d1", "park@naver.com", "upper", "general", null, "N", "Y");
INSERT INTO user VALUES ("u2205201221", "bella", "a03ea09072d789adff29aff6a3758e9294c96ce803915c1456384eaa6e2d2df9", "bella@gmail.com", "lower", null, "move move", "Y", "Y");
INSERT INTO user VALUES ("u2205201222", "james", "119c9ae6f9ca741bd0a76f87fba0b22cab5413187afb2906aa2875c38e213603", "james@gmail.com", null, null, "Hi", "N", "N");
INSERT INTO user VALUES ("u2205201223", "noa", "7467b914d771fcfd9291894768fa54543b2f7c45265cddc8bb6a97168f214328", "noa@outlook.com", "upper", null, "Never give up", "N", "N");
INSERT INTO user VALUES ("u2205201224", "angelina", "710c3906ca8b54f86c9e020d989792d03b9a0d8904d7b57b3f57e74ab1746625", "angelina@gmail.com", "lower", "whole", "🧡", "N", "N");
SELECT * FROM user;

## heart(찜) 테이블 
### 임의 데이터 생성
INSERT INTO heart VALUES("h2205230405", "u2205201218", "v2205221413", "2022-05-21");
INSERT INTO heart VALUES("h2205230406", "u2205201219", "v2205221414", "2022-05-22");
INSERT INTO heart VALUES("h2205230407", "u2205201220", "v2205221419", "2022-05-12");
INSERT INTO heart VALUES("h2205230408", "u2205201218", "v2205221412", "2022-05-10");
INSERT INTO heart VALUES("h2205230409", "u2205201221", "v2205221413", "2022-05-14");
INSERT INTO heart VALUES("h2205230410", "u2205201218", "v2205221414", "2022-05-17");
INSERT INTO heart VALUES("h2205230411", "u2205201218", "v2205221419", "2022-05-18");
INSERT INTO heart VALUES("h2205230412", "u2205201219", "v2205221419", "2022-05-19");
INSERT INTO heart VALUES("h2205230413", "u2205201220", "v2205191503", "2022-05-20");
INSERT INTO heart VALUES("h2205230414", "u2205201221", "v2205191505", "2022-05-21");
INSERT INTO heart VALUES("h2205230415", "u2205201221", "v2205191503", "2022-05-22");
SELECT * FROM heart;
### 찜 데이터에 맞게 video 테이블의 영상별 찜 개수 수동으로 조절
UPDATE video SET count_heart = 1 WHERE id = "v2205221412";
UPDATE video SET count_heart = 2 WHERE id = "v2205221413";
UPDATE video SET count_heart = 2 WHERE id = "v2205221414";
UPDATE video SET count_heart = 3 WHERE id = "v2205221419";
UPDATE video SET count_heart = 2 WHERE id = "v2205191503";
UPDATE video SET count_heart = 1 WHERE id = "v2205191505";
SELECT * FROM video;

## performance(운동 기록) 테이블
INSERT INTO performance VALUES ("p2205241320", "u2205201219", 557, 128, 22, 120, "2022-05-23");
INSERT INTO performance VALUES ("p2205241319", "u2205201219", 285, 125, 22, 60, "2022-05-22");
INSERT INTO performance VALUES ("p2205241318", "u2205201219", 560, 127, 22, 120, "2022-04-21");
INSERT INTO performance VALUES ("p2205241317", "u2205201219", 800, 126, 23, 180, "2022-04-20");
INSERT INTO performance VALUES ("p2205241316", "u2205201219", 450, 128, 23, 100, "2022-04-17");
INSERT INTO performance VALUES ("p2205241315", "u2205201219", 600, 129, 24, 125, "2022-04-15");
INSERT INTO performance VALUES ("p2205241815", "u2205201220", 600, 129, 22, 125, "2022-05-14");
INSERT INTO performance VALUES ("p2205241816", "u2205201220", 805, 135, 22, 200, "2022-05-15");
INSERT INTO performance VALUES ("p2205241817", "u2205201220", 650, 127, 22, 155, "2022-04-16");
INSERT INTO performance VALUES ("p2205241818", "u2205201220", 670, 126, 21, 175, "2022-04-19");
INSERT INTO performance VALUES ("p2205241819", "u2205201220", 700, 126, 21, 165, "2022-04-20");
INSERT INTO performance VALUES ("p2205241820", "u2205201221", 700, 133, 24, 120, "2022-04-24");
SELECT * FROM performance;

## friend(친구 관계) 테이블
INSERT INTO friend VALUES ("f2205250905", "u2205201218", "u2205201219", "2022-05-25");
INSERT INTO friend VALUES ("f2205250906", "u2205201218", "u2205201220", "2022-05-25");
INSERT INTO friend VALUES ("f2205250907", "u2205201218", "u2205201221", "2022-05-25");
INSERT INTO friend VALUES ("f2205250908", "u2205201218", "u2205201222", "2022-05-25");
INSERT INTO friend VALUES ("f2205250909", "u2205201219", "u2205201220", "2022-05-25");
INSERT INTO friend VALUES ("f2205250910", "u2205201220", "u2205201221", "2022-05-25");
INSERT INTO friend VALUES ("f2205250911", "u2205201220", "u2205201222", "2022-05-25");
SELECT * FROM friend;

## comment(댓글) 테이블 
INSERT INTO comment VALUES ("c2205251255", "u2205201218", "v2205221419", "2022-05-20", "Love you all");
INSERT INTO comment VALUES ("c2205251256", "u2205201219", "v2205221418", "2022-05-21", "useful");
INSERT INTO comment VALUES ("c2205251257", "u2205201220", "v2205221417", "2022-05-22", "so nice");
INSERT INTO comment VALUES ("c2205251258", "u2205201221", "v2205191503", "2022-05-23", "I love it");
INSERT INTO comment VALUES ("c2205251259", "u2205201219", "v2205191502", "2022-05-24", "useful~");
INSERT INTO comment VALUES ("c2205251260", "u2205201220", "v2205191501", "2022-05-24", "so nice!");
INSERT INTO comment VALUES ("c2205251261", "u2205201222", "v2205191501", "2022-05-25", "gooddddd");
INSERT INTO comment VALUES ("c2205251262", "u2205201218", "v2205221414", "2022-05-25", "godd!");
INSERT INTO comment VALUES ("c2205251263", "u2205201223", "v2205221415", "2022-05-25", "Greatttt");
SELECT * FROM comment;