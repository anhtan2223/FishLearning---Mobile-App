package com.example.fish.Untils

object DemoData {
    val UserInfo = User(
        "1" ,
        "Lê Sỹ Anh Tấn" ,
        "anhtan3332@gmail.com" ,
        "anhtan2223" ,
        "123" ,
        1
    )
    val UserInfo2 = User(
        "2" ,
        "Lê Sỹ Anh Tấn" ,
        "anhtan3332@gmail.com" ,
        "anhtan2223" ,
        "123" ,
        2
    )
    val ListUserPush = listOf<User>(
        User(
            "~" ,
            "Tạ Hồng Thư","day2@gmail.com","day2","12345678",
            2
        ) ,
        User(
            "~" ,
            "Dương Ngọc Quế","day5@gmail.com","day5","12345678",
            2
        ) ,
        User(
            "~" ,
            "Hồ Gia Bảo","day4@gmail.com","day4","12345678",
            2
        ) ,
        User(
            "~" ,
            "Đỗ An Nam","day6@gmail.com","day6","12345678",
            2
        ) ,
        User(
            "~" ,
            "Lý Phi Ðiệp","hoc1@gmail.com","hoc1","12345678",
            3
        ) ,
        User(
            "~" ,
            "Nghiêm Cát Uy","hoc2@gmail.com","hoc2","12345678",
            3
        ) ,
        User(
            "~" ,
            "Phí Trung Nhân","hoc3@gmail.com","hoc3","12345678",
            3
        ) ,
        User(
            "~" ,
            "Liều Ðình Na","hoc4@gmail.com","hoc4","12345678",
            3
        ) ,
        User(
            "~" ,
            "Đặng Bảo Thái","hoc5@gmail.com","hoc5","12345678",
            3
        ) ,
        User(
            "~" ,
            "Đỗ Phương Nam","hoc6@gmail.com","hoc6","12345678",
            3
        ) ,
        User(
            "~" ,
            "Mạc Minh Nhân","hoc7@gmail.com","hoc7","12345678",
            3
        ) ,
        User(
            "~" ,
            "Phạm Đăng Quang","hoc8@gmail.com","hoc8","12345678",
            3
        ) ,
        User(
            "~" ,
            "Doãn Minh Vương","hoc9@gmail.com","hoc9","12345678",
            3
        ) ,
        User(
            "~" ,
            "Huỳnh Hưng Ðạo","hoc10@gmail.com","hoc10","12345678",
            3
        ) ,
    )
    val ListUser = mutableListOf<User>(
        User(
            "admin" ,
            "Admin" , "admin@gmail.com" , "admin" , "123" ,
            1
        ) ,
        User(
            "teacher" ,
            "Giáo Viên" , "teacher@gmail.com" , "teacher" , "123" ,
            2
        ) ,
        User(
            "user" ,
            "Lê Sỹ Anh Tấn" , "user@gmail.com" , "user" , "123" ,
            3
        ) ,
        User(
            "teacher1" ,
            "Huỳnh Ngọc Thái Anh" , "hntanh@gmail.com" , "hntanh" , "12345678" ,
            2
        ) ,
        User(
            "teacher2" ,
            "Lý Ðắc Trọng" , "ldt@gmail.com" , "ldtrong" , "12345678" ,
            2
        ) ,
        User(
            "teacher3" ,
            "Hoàng Chí Thanh" , "htcthanh@gmail.com" , "hcthanh" , "12345678" ,
            2
        ) ,
        User(
            "teacher4" ,
            "Nguyễn Tuấn Việt" , "ntviet@gmail.com" , "ntviet" , "12345678" ,
            2
        ) ,
        User(
            "teacher5" ,
            "Bạch Ðức Hải" , "bdhai@gmail.com" , "bdhai" , "12345678" ,
            2
        ) ,
        User(
            "student1" ,
            "Lê Sỹ Anh Tấn" ,
            "anhtan3332@gmail.com" ,
            "lsatan" ,
            "12345678" ,
            3
        ) ,
        User(
            "student2" ,
            "Vũ Huy Lĩnh" ,
            "chlinh@gmail.com" ,
            "vhlinh" ,
            "12345678" ,
            3
        ) ,
        User(
            "student3" ,
            "Bùi Huyền Trân" ,
            "bhtran@gmail.com" ,
            "bhtran" ,
            "12345678" ,
            3
        ) ,
        User(
            "student4" ,
            "Phó Cát Uy" ,
            "pcuy@gmail.com" ,
            "pcuy" ,
            "12345678" ,
            3
        ) ,
        User(
            "student5" ,
            "Tạ Minh Triệu" ,
            "tmtrieu@gmail.com" ,
            "tmtrieu" ,
            "12345678" ,
            3
        ) ,
    )
    val ListClass = listOf<Class>(
        Class(
            "1",
            "Cybersecurity Fundamentals" ,
            "Nam 2023-2024" ,
            "teacher1"
        ) ,
        Class(
            "2",
            "Machine Learning" ,
            "HK2 - Nam Hoc 2023-2024" ,
            "teacher3"
        ) ,
        Class(
            "3",
            "OOP" ,
            "Nam 2023-2024" ,
            "teacher4"
        ) ,
        Class(
            "4",
            "Discrete Mathematics" ,
            "Toán Rời Rạc - 2023-2024" ,
            "teacher2"
        ) ,
        Class(
            "5",
            "Graph Theory" ,
            "Nam 2023-2024" ,
            "teacher5"
        ) ,
        Class(
            "6",
            "Big Data Analytics" ,
            "Niên Khoá 2023-2024" ,
            "teacher1"
        ) ,
        Class(
            "7",
            "Cloud Computing" ,
            "Học Kỳ 1 - Năm Học 2023-2024" ,
            "teacher3"
        ) ,
        Class(
            "8",
            "Data Visualization" ,
            "Niên Khoá Kỳ 1 Năm 2022-2023" ,
            "teacher4"
        ) ,
        Class(
            "9",
            "Game Development with Unity" ,
            "Nam 2023-2024" ,
            "teacher1"
        ) ,
        Class(
            "10",
            "Natural Language Processing" ,
            "Năm 2023-2024" ,
            "teacher3"
        ) ,
        Class(
            "11",
            "Digital Image Analysis" ,
            "Năm 2022-2023" ,
            "teacher2"
        ) ,
        Class(
            "12",
            "Internet of Things (IoT)" ,
            "Năm 2023-2024" ,
            "teacher4"
        ) ,
        Class(
            "13",
            "Speech Recognition" ,
            "Năm 2023-2024" ,
            "teacher1"
        ) ,
        Class(
            "14",
            "Computer Architecture" ,
            "Năm 2023-2024" ,
            "teacher3"
        ) ,
        Class(
            "15",
            "Biomedical Signal Processing" ,
            "Năm 2023-2024" ,
            "teacher2"
        ) ,
    )
    val myClass = listOf<Class>(
        Class(
            "2",
            "Machine Learning" ,
            "HK2 - Nam Hoc 2023-2024" ,
            "Nguyễn Tuấn Việt"
        ),
        Class(
            "3",
            "OOP" ,
            "Nam 2023-2024" ,
            "Lý Trọng Dũng"
        ) ,
        Class(
            "5",
            "Graph Theory" ,
            "Nam 2023-2024" ,
            "Nguyễn Minh Thông"
        )
    )
    val Topic = listOf<Topic>(
        Topic(
            "1",
            "Chủ Đề Số 1" ,
            "0"
        ) ,
        Topic(
            "2",
            "Chủ Đề 2" ,
        ) ,
        Topic(
            "3",
            "Chủ Đề Số 3" ,
        ) ,
        Topic(
            "4",
            "Chủ Đề 4"
        ) ,
    )
    val InsideTopic = listOf<Any>(
        TextBox(
            "0" ,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." ,
            "1"
            ) ,
        TextBox(
            "1" ,
            "Một Đoạn Văn Bản Sẽ Hiển Thị Như Trên" ,
            "2"
        ) ,
        Document(
            "0" ,
            "Đây Là Tiêu Đề Cho Một Tài Liệu Để Tải Về" ,
            "Word" ,
            "3"
        ) ,
        Document(
            "2",
            "Một Tài Liệu Sẽ Như Thế Này" ,
            "Word" ,
            "4"
        ) ,
        Test(
            "0",
            "Tên Của Bài Kiểm Tra" ,
            6 ,
            1800 ,
            "1"
        ) ,
        Test(
            "1" ,
            "Kiểm Tra Giữa Kỳ" ,
            5 ,
            5 ,
            "3"
        ) ,
        Test(
            "2" ,
            "TOEIC" ,
            200 ,
            120 ,
            "1"
        )
    )
    val QuestionList = listOf<Question>(
        Question(
            "0" ,
            "Ví Dụ Của Một Câu Hỏi" ,
            "0"
        ) ,
        Question(
            "1" ,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Te enim iudicem aequum puto, modo quae dicat ille bene noris. Apparet statim, quae sint officia, quae actiones" ,
            "2"
        ) ,
        Question(
            "2" ,
            "Con Cá Có Mấy Tay" ,
            "0"
        ) ,
        Question(
            "3" ,
            "Con Cá Có Mấy Mắt" ,
            "0"
        ) ,
        Question(
            "4" ,
            "Con Cá Có Mấy Mắt" ,
            "0"
        ) ,
        Question(
            "5" ,
            "Con Cá " ,
            "0"
        ) ,
        Question(
            "6" ,
            "Con Cá " ,
            "0"
        ) ,
    )
    val AnswerList = listOf<Answer>(
        Answer(
            "0" ,
            "Câu Trả Lời Đúng" ,
            true ,
            "0"
        ) ,
        Answer(
            "1" ,
            "Câu Trả Lời Sẽ Như Thế Này" ,
            false ,
            "0"
        ) ,
        Answer(
            "2" ,
            "Câu Trả Lời Sai" ,
            false ,
            "0"
        ) ,
        Answer(
            "3" ,
            "Và Có Thể Có Số Lượng Câu Trả Lời Đúng Và Sai Là Tuỳ Ý" ,
            false ,
            "0"
        ) ,
        Answer(
            "4" ,
            "0" ,
            true ,
            "1"
        ) ,
        Answer(
            "5" ,
            "1" ,
            false ,
            "1"
        ) ,
        Answer(
            "6" ,
            "2" ,
            false ,
            "1"
        ) ,
        Answer(
            "7" ,
            "3" ,
            false ,
            "1"
        ) ,
        Answer(
            "8" ,
            "0" ,
            true ,
            "2"
        ) ,
        Answer(
            "9" ,
            "1" ,
            false ,
            "2"
        ) ,
        Answer(
            "10" ,
            "2" ,
            false ,
            "2"
        ) ,
        Answer(
            "11" ,
            "3" ,
            false ,
            "2"
        ) ,
        Answer(
            "12" ,
            "0" ,
            false ,
            "3"
        ) ,
        Answer(
            "13" ,
            "1" ,
            false ,
            "3"
        ) ,
        Answer(
            "14" ,
            "2" ,
            false ,
            "3"
        ) ,
        Answer(
            "15" ,
            "3" ,
            true ,
            "3"
        ) ,
        Answer(
            "16" ,
            "4" ,
            false ,
            "3"
        ) ,
        Answer(
            "17" ,
            "5" ,
            false ,
            "3"
        ) ,
        Answer(
            "18" ,
            "3" ,
            false ,
            "3"
        ),
        Answer(
            "19" ,
            "0" ,
            false ,
            "4"
        ) ,
        Answer(
            "20" ,
            "1" ,
            false ,
            "4"
        ) ,
        Answer(
            "21" ,
            "2" ,
            true ,
            "4"
        ) ,
        Answer(
            "22" ,
            "3" ,
            false ,
            "4"
        ) ,
        Answer(
            "23" ,
            "0" ,
            false ,
            "5"
        ) ,
        Answer(
            "24" ,
            "1" ,
            false ,
            "5"
        ) ,
        Answer(
            "25" ,
            "2" ,
            true ,
            "5"
        ) ,
        Answer(
            "26" ,
            "3" ,
            false ,
            "5"
        ) ,
        Answer(
            "27" ,
            "0" ,
            false ,
            "6"
        ) ,
        Answer(
            "28" ,
            "1" ,
            false ,
            "6"
        ) ,
        Answer(
            "29" ,
            "2" ,
            true ,
            "6"
        ) ,
        Answer(
            "30" ,
            "3" ,
            false ,
            "6"
        )
    )
//    val InsideTopic = listOf<Any>()

}