package com.example.fish.Model

object DemoData {
    val UserInfo = User(
        1 ,
        "Lê Sỹ Anh Tấn" ,
        "anhtan3332@gmail.com" ,
        "anhtan2223" ,
        "12345" ,
        1
    )
    val UserInfo2 = User(
        2 ,
        "Lê Sỹ Anh Tấn" ,
        "anhtan3332@gmail.com" ,
        "anhtan2223" ,
        "12345" ,
        2
    )
    val ListUser = listOf<User>(
        User(
            1 ,
            "Giáo Viên" ,
            "anhtan3332@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            2
        ) ,
        User(
            2 ,
            "Tôn Ðình Phúc" ,
            "user1@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            1
        ) ,
        User(
            3 ,
            "Nguyễn Triệu Thái" ,
            "user2@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            1
        ) ,
        User(
            4 ,
            "Lý Ðắc Trọng" ,
            "user3@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            1
        ) ,
        User(
            5 ,
            "Lê Sỹ Anh Tấn" ,
            "anhtan3332@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            1
        ) ,
        User(
            6 ,
            "Vũ Huy Lĩnh" ,
            "user6@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            1
        ) ,
        User(
            7 ,
            "Bùi Huyền Trân" ,
            "user7@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            1
        ) ,
        User(
            8 ,
            "Hoàng Diệu Ngọc" ,
            "user8@gmail.com" ,
            "anhtan2223" ,
            "12345" ,
            1
        ) ,
    )
    val ListClass = listOf<Class>(
        Class(
            1,
            "Math Basic" ,
            "Nam 2023-2024" ,
            "Anh Tan"
        ) ,
        Class(
            2,
            "Machine Learning" ,
            "HK2 - Nam Hoc 2023-2024" ,
            "Hoàng Chí Thanh"
        ) ,
        Class(
            3,
            "OOP" ,
            "Nam 2023-2024" ,
            "Nguyễn Tuấn Việt"
        ) ,
        Class(
            4,
            "Math Basic" ,
            "Nam 2023-2024" ,
            "Hoàng Ðông Sơn"
        ) ,
        Class(
            5,
            "Graph Theory" ,
            "Nam 2023-2024" ,
            "Bạch Ðức Hải"
        ) ,
        Class(
            6,
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day A"
        ) ,
        Class(
            7,
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day B"
        ) ,
        Class(
            8,
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day 2"
        ) ,
        Class(
            9,
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day 3"
        ) ,
        Class(
            10,
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day 4"
        ) ,
    )
    val myClass = listOf<Class>(
        Class(
            2,
            "Machine Learning" ,
            "HK2 - Nam Hoc 2023-2024" ,
            "Nguyễn Tuấn Việt"
        ),
        Class(
            3,
            "OOP" ,
            "Nam 2023-2024" ,
            "Lý Trọng Dũng"
        ) ,
        Class(
            5,
            "Graph Theory" ,
            "Nam 2023-2024" ,
            "Nguyễn Minh Thông"
        )
    )
    val Topic = listOf<Topic>(
        Topic(
            1,
            "Chủ Đề Số 1" ,
            0
        ) ,
        Topic(
            2,
            "Chủ Đề 2" ,
        ) ,
        Topic(
            3,
            "Chủ Đề Số 3" ,
        ) ,
        Topic(
            4,
            "Chủ Đề 4"
        ) ,
    )
    val InsideTopic = listOf<Any>(
        TextBox(
            0 ,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." ,
            1
            ) ,
        TextBox(
            1 ,
            "Một Đoạn Văn Bản Sẽ Hiển Thị Như Trên" ,
            2
        ) ,
        Document(
            0 ,
            "Đây Là Tiêu Đề Cho Một Tài Liệu Để Tải Về" ,
            1 ,
            3
        ) ,
        Document(
            2,
            "Một Tài Liệu Sẽ Như Thế Này" ,
            1 ,
            4
        ) ,
        Test(
            0,
            "Tên Của Bài Kiểm Tra" ,
            6 ,
            1800 ,
            1
        ) ,
        Test(
            1 ,
            "Kiểm Tra Giữa Kỳ" ,
            5 ,
            5 ,
            3
        ) ,
        Test(
            2 ,
            "TOEIC" ,
            200 ,
            120 ,
            1
        )
    )
    val QuestionList = listOf<Question>(
        Question(
            0 ,
            "Ví Dụ Của Một Câu Hỏi" ,
            0
        ) ,
        Question(
            1 ,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Te enim iudicem aequum puto, modo quae dicat ille bene noris. Apparet statim, quae sint officia, quae actiones" ,
            2
        ) ,
        Question(
            2 ,
            "Con Cá Có Mấy Tay" ,
            0
        ) ,
        Question(
            3 ,
            "Con Cá Có Mấy Mắt" ,
            0
        ) ,
        Question(
            4 ,
            "Con Cá Có Mấy Mắt" ,
            0
        ) ,
        Question(
            5 ,
            "Con Cá " ,
            0
        ) ,
        Question(
            6 ,
            "Con Cá " ,
            0
        ) ,
    )
    val AnswerList = listOf<Answer>(
        Answer(
            0 ,
            "Câu Trả Lời Đúng" ,
            true ,
            0
        ) ,
        Answer(
            1 ,
            "Câu Trả Lời Sẽ Như Thế Này" ,
            false ,
            0
        ) ,
        Answer(
            2 ,
            "Câu Trả Lời Sai" ,
            false ,
            0
        ) ,
        Answer(
            3 ,
            "Và Có Thể Có Số Lượng Câu Trả Lời Đúng Và Sai Là Tuỳ Ý" ,
            false ,
            0
        ) ,
        Answer(
            4 ,
            "0" ,
            true ,
            1
        ) ,
        Answer(
            5 ,
            "1" ,
            false ,
            1
        ) ,
        Answer(
            6 ,
            "2" ,
            false ,
            1
        ) ,
        Answer(
            7 ,
            "3" ,
            false ,
            1
        ) ,
        Answer(
            8 ,
            "0" ,
            true ,
            2
        ) ,
        Answer(
            9 ,
            "1" ,
            false ,
            2
        ) ,
        Answer(
            10 ,
            "2" ,
            false ,
            2
        ) ,
        Answer(
            11 ,
            "3" ,
            false ,
            2
        ) ,
        Answer(
            12 ,
            "0" ,
            false ,
            3
        ) ,
        Answer(
            13 ,
            "1" ,
            false ,
            3
        ) ,
        Answer(
            14 ,
            "2" ,
            false ,
            3
        ) ,
        Answer(
            15 ,
            "3" ,
            true ,
            3
        ) ,
        Answer(
            16 ,
            "4" ,
            false ,
            3
        ) ,
        Answer(
            17 ,
            "5" ,
            false ,
            3
        ) ,
        Answer(
            18 ,
            "3" ,
            false ,
            3
        ),
        Answer(
            19 ,
            "0" ,
            false ,
            4
        ) ,
        Answer(
            20 ,
            "1" ,
            false ,
            4
        ) ,
        Answer(
            21 ,
            "2" ,
            true ,
            4
        ) ,
        Answer(
            22 ,
            "3" ,
            false ,
            4
        ) ,
        Answer(
            23 ,
            "0" ,
            false ,
            5
        ) ,
        Answer(
            24 ,
            "1" ,
            false ,
            5
        ) ,
        Answer(
            25 ,
            "2" ,
            true ,
            5
        ) ,
        Answer(
            26 ,
            "3" ,
            false ,
            5
        ) ,
        Answer(
            27 ,
            "0" ,
            false ,
            6
        ) ,
        Answer(
            28 ,
            "1" ,
            false ,
            6
        ) ,
        Answer(
            29 ,
            "2" ,
            true ,
            6
        ) ,
        Answer(
            30 ,
            "3" ,
            false ,
            6
        )
    )
//    val InsideTopic = listOf<Any>()

}