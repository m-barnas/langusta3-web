export const fetchPattern = (patternID) => {
  return fetch('langusta3/pattern/' + patternID)
}
export const fetchAllPatterns = () => {
  console.log('Fetching all patterns');
  console.time('fetchAllPatterns');

  return fetch('PB138/langusta3/pattern/findall').then((response) => {
      if (response.ok) {
        console.timeEnd('fetchAllPatterns');
        return response.json();
      }
      throw new Error('Not ok');
    }, (err) => {
      console.log('fetch problem');
      throw err;
    }
  ).catch(
    (err) => {
      console.log('problem parsing response')
      throw err;
    }
  )
}
export const fetchWord = (word) => {
  return fetch('langusta3/word/' + word)
}
