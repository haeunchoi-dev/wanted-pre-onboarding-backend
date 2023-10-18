## 요구사항 분석

- ORM 사용하여 구현 : ORM인 `prisma` 사용
- RDBMS 사용 : `mysql` 사용
- Git commit 메시지 컨벤션 : 유다시티

## 구현 과정

### 0. modeling

![image](https://github.com/haeunchoi-dev/wanted-pre-onboarding-backend/assets/132250432/69872f93-8d3c-474b-9f71-4f49c16568e0)

### 1. 채용 공고 CRUD

- GET /api/v1/notice/all : 채용 공고의 모든 데이터를 조회

```json

  {
    "error": null,
    "data": [
      {
        "id": 1,
        "position": "백엔드 주니어 개발자",
        "reward": 1000000,
        "tech": "Python",
        "company": "원티드랩",
        "region": "서울",
        "contry": "한국"
      },
      {
        "id": 3,
        "position": "백엔드 시니어 개발자",
        "reward": 1000000,
        "tech": "Python",
        "company": "원티드랩",
        "region": "서울",
        "contry": "한국"
      }
    ]
  }

```

- POST /api/v1/notice : 채용 공고 생성

생성 요청 데이터

```json
{
  "company_id":1,
  "position":"백엔드 시니어 개발자",
  "reward":1000000,
  "detail":"원티드랩에서 백엔드 시니어 개발자를 채용합니다. 자격요건은..",
  "tech":"Python"
}
```

생성 결과 데이터

```json
{
  "error": null,
  "data": {
    "id": 1,
    "position": "백엔드 시니어 개발자",
    "reward": 1000000,
    "tech": "Python",
    "detail": "원티드랩에서 백엔드 시니어 개발자를 채용합니다. 자격요건은..",
    "company_id": 1
  }
}
```

- PUT /api/v1/notice/:id : 해당 id의 채용 공고 수정

원본 데이터

```json
{
  "id": 1,
  "position": "백엔드 시니어 개발자",
  "reward": 1000000,
  "tech": "Python",
  "detail": "원티드랩에서 백엔드 시니어 개발자를 채용합니다. 자격요건은..",
  "company_id": 1
}
```

변경 요청 데이터

```json
{
  "position": "백엔드 개발자",
  "reward": 1000000,
  "tech": "Python",
  "detail": "원티드랩에서 백엔드 개발자를 채용합니다. 자격요건은.."
}
```

변경 결과 데이터

```json
{
  "error": null,
  "data": {
    "id": 1,
    "position": "백엔드 개발자",
    "reward": 1000000,
    "tech": "Python",
    "detail": "원티드랩에서 개발자를 채용합니다. 자격요건은..",
    "company_id": 1
  }
}
```

- Get /api/v1/notice/:id : 채용 상세 페이지를 위한 데이터 조회

```json
{
  "error": null,
  "data": {
    "id": 4,
    "position": "백엔드  개발자",
    "reward": 1000000,
    "tech": "Python",
    "detail": "원티드랩에서 백엔드  개발자를 채용합니다. 자격요건은..",
    "company": "원티드랩",
    "region": "서울",
    "contry": "한국"
  }
}
```

- DELETE /api/v1/notice/:id : 해당 id의 채용 공고 삭제

## License

Nest is [MIT licensed](LICENSE).