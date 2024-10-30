REST API의 요청 URL
------------------------------------------------------
<table>
  <thead>
      <tr>
        <th>구분</th>
        <th>요청방식</th>
        <th>요청URL</th>
        <th>요청데이터</th>
        <th>응답데이터</th>
      </tr>
  </thead>
  <tbody>
      <tr>
        <td>조회</td>
        <td>GET</td>
        <td>/api/v1/user</td>
        <td>없음</td>
        <td>모든 사용자정보</td>
      </tr>
      <tr>
        <td>검색</td>
        <td>GET</td>
        <td>/api/v1/user?name=응수</td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>조회</td>
        <td>GET</td>
        <td>/api/v1/user/1000</td>
        <td>없음</td>
        <td>1000번 사용자정보</td>
      </tr>
      <tr>
        <td>추가</td>
        <td>POST</td>
        <td>/api/v1/user</td>
        <td>신규 사용자정보</td>
        <td>없음</td>
      </tr>
      <tr>
        <td>삭제</td>
        <td>DELETE</td>
        <td>/api/v1/user/1000</td>
        <td>없음</td>
        <td>없음</td>
      </tr>
      <tr>
        <td>수정</td>
        <td>PUT</td>
        <td>/api/v1/user/1000</td>
        <td>수정된 사용자정보</td>
        <td>없음</td>
      </tr>
  </tbody>
</table>

<table>
  <thead>
      <tr>
        <th>구분</th>
        <th>요청방식</th>
        <th>요청URL</th>
        <th>요청데이터</th>
        <th>응답데이터</th>
      </tr>
  </thead>
  <tbody>
      <tr>
        <td>조회</td>
        <td>GET</td>
        <td>/api/v1/book/소설</td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>조회</td>
        <td>GET</td>
        <td>/api/v1/book/소설/한국소설</td>
        <td></td>
        <td></td>
      </tr>
  </tbody>
</table>

#### 아직은 봐도 모르니 그냥 보고 지나가기
