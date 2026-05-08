# 일기장 애플리케이션 프로젝트 (Diary Application Project)

## 프로젝트 개요
MySQL 데이터베이스를 사용하여 일기를 등록, 조회, 검색 및 삭제할 수 있는 간단한 Java Swing 기반 애플리케이션입니다.

## 아키텍처
본 프로젝트는 기본적인 MVC 패턴과 유사한 구조를 따릅니다:
- **Model (`test.DiaryEntry`)**: ID, 제목, 내용, 생성 시간을 포함하는 일기 엔티티를 나타냅니다.
- **DAO (`test.DiaryDAO`)**: JDBC를 사용하여 데이터베이스 연결 및 CRUD 작업을 처리합니다.
- **UI (`test.DiaryUI`)**: 사용자와의 상호작용을 위한 Java Swing 기반 인터페이스입니다.
- **App Entry (`test.DiaryApp`)**: UI를 초기화하고 애플리케이션을 시작하는 메인 진입점입니다.

## 파일 설명
- `src/test/DiaryApp.java`: 애플리케이션 실행을 위한 메인 클래스입니다.
- `src/test/DiaryUI.java`: 주요 UI 컴포넌트입니다. `BorderLayout`과 `FlowLayout`을 사용합니다.
- `src/test/DiaryDAO.java`: 데이터베이스 접근 로직입니다. MySQL JDBC 드라이버가 필요합니다.
- `src/test/DiaryEntry.java`: 일기 데이터를 위한 데이터 모델 클래스입니다.

## 데이터베이스 설정
- **데이터베이스 이름**: `diary_db`
- **테이블 이름**: `diary_entries`
- **필드 구성**:
  - `id`: INT (Primary Key, Auto Increment)
  - `title`: VARCHAR(255)
  - `content`: TEXT
  - `created_at`: TIMESTAMP (기본값 CURRENT_TIMESTAMP)

> **참고**: `DiaryDAO.java`에서 본인의 로컬 MySQL `USER`와 `PASSWORD` 정보를 업데이트해야 합니다.

## 개발 규칙 및 컨벤션
- **인코딩**: 한글 처리를 위해 컴파일 시 항상 `UTF-8`을 사용해야 합니다.
  - 명령어: `javac -encoding UTF-8 ...`
- **UI 레이아웃**:
  - 상단 영역(입력창 + 버튼들)은 하나의 패널로 묶어 `NORTH` 위치에 배치합니다.
  - 일기 목록(`JScrollPane`)은 `CENTER` 영역을 차지하도록 합니다.
- **스타일링**: 일관된 버튼 외형을 위해 `DiaryUI`의 `createStyledButton` 메서드를 사용합니다. 버튼 글씨 색상은 `Color.BLACK`으로 유지합니다.
