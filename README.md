## 起動方法

```
cd frontend
npm run dev
```

```
cd backend
mvn spring-boot:run
```

http://localhost:5173/ にアクセス。  


## お試しで実装したこと

* フロント・バックを1つのリポジトリにまとめる
* GET、POSTができるようになる（ユーザのアカウント確認のためのPOST、画面下部の質問一覧のGET）
  * Spring Securityは入れていない
* H2 Databaseが使えるようになる
