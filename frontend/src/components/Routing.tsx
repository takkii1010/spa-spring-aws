import { Route, Routes } from 'react-router-dom';
import { Home } from './pages/Home/Home';

// src/pages/Page404.tsx
export const Page404 = () => {
  return (
    <div>
      <h1>404 Page</h1>
    </div>
  );
};

export const Routing = () => {
  return (
    <Routes>
      {/* 質問一覧画面 */}
      <Route index element={<Home />} />
    </Routes>
  );
};
