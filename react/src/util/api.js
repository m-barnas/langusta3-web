export const fetchPattern = (patternID) => {
  return fetch('/pattern/' + patternID, {
    method: 'GET'
  })
}
export const fetchAllPatterns = () => {
  return fetch('/pattern/findall', {
    method: 'GET'
  })
}
export const fetchWord = (word) => {
  return fetch('/word/' + word, {
    method: 'GET'
  })
}
