import './App.css';
import Main from './page/Main.tsx';

function App() {
  return (
    <>
      <header>
        <a href="/">
          <p>여행플래너</p>
        </a>

        <nav>
          <ul>
            <li>피드</li>
            <li>여행 검색</li>
            <li>여행 만들기</li>
            <li>내 여행</li>
          </ul>
        </nav>
      </header>

      <main>
        <Main />
      </main>
    </>
  );
}

export default App;
