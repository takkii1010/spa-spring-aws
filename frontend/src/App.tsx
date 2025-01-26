import { BrowserRouter } from 'react-router-dom';
import { Routing } from './components/Routing';

export function App() {
  return (
    <BrowserRouter>
      <Routing />
    </BrowserRouter>
  );
}

export default App;