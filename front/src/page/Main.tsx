import TripCardList from '../component/TripCardList.tsx';

function Main() {
  return (
    <>
      <section>
        <h2>당신만의 특별한 여행을 계획하고 공유하세요</h2>
        <p>다른 여행자들의 경험을 통해 완벽한 여행을 만들어보세요.</p>
        <button>여행 검색하기</button>
        <button>여행 만들기</button>
      </section>

      {/* Todo : 베너 아래 영역 */}
      <section>
        <section>
          <h4>인기 여행 피드</h4>
        </section>

        <section>
          <TripCardList />
        </section>
      </section>
    </>
  );
}

export default Main;
