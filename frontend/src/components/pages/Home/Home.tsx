import { useEffect, useState } from 'react';
import styles from './Home.module.scss';

type Question = {
  id: number
  text: string
}

/**
 * 質問を一覧で表示するコンポーネント。
 */
export const Home = () => {
  const [questions, setQuestions] = useState<Question[]>([]);
  const [userId, setUserId] = useState('');
  const [userPassword, setUserPassword] = useState('');

  useEffect(() => {
    const fetchQuestions = async () => {
      const response = await fetch('http://localhost:9080/api/qa');
      console.log('response:', response);
    if (response.ok) {
        const result = await response.json();
        setQuestions(result);
      } else {
        console.error('質問の取得に失敗しました');
    }};
    fetchQuestions();
  }, []);

  const handleLogin = async (event: React.FormEvent) => {
    event.preventDefault();

    try {
      const loginResponse = await fetch('http://localhost:9080/api/user', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ userId, userPassword }),
      });

      if (loginResponse.ok) {
        console.log('ログイン成功:', loginResponse);
      } else {
        console.error('ログイン失敗:', loginResponse);
      }

    } catch (error) {
      console.error('ログインエラー:', error);
    }
  };


  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();

    const text = (event.target as HTMLFormElement).text.value;

    // TODO: 403 Forbidden エラーが発生する
    const response = await fetch('http://localhost:9080/api/qa', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        body: JSON.stringify({ text }),
        mode: 'cors',
        credentials: 'include',
        redirect: 'manual',
    });
    console.log('response:', response);

    if (response.ok) {
        const result = await response.json();
        console.log('質問が送信されました:', result);

    } else {
        console.error('質問の送信に失敗しました');
    }
  };


  return (
    <div className={styles.content}>
      <header className={styles.header}>
          <h1 className={styles.title}>質問一覧</h1>            
      </header>
      <form method="post" onSubmit={handleLogin}>
        <div>
          <input
            type="text"
            name="userId"
            placeholder="ユーザー名"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
          />
        </div>
        <div>
          <input
            type="userPassword"
            name="userPassword"
            placeholder="パスワード"
            value={userPassword}
            onChange={(e) => setUserPassword(e.target.value)}
          />
        </div>
        <button className={styles.button} type="submit">
          ログイン
        </button>
      </form>
      <form method="post" onSubmit={handleSubmit}>
        <div>
          <textarea className={styles.input} name="text" placeholder="質問内容を記入してください" cols={50} rows={10}/>
        </div>
        <button className={styles.button} type="submit">送信</button>
      </form>
      <ul>
        {questions.map((question, index) => (
          <li key={index}>{question.text}</li>
        ))}
      </ul>
    </div>
  );
};
