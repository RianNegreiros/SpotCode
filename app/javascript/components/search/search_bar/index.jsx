import React, { useState } from 'react'
import { Form } from 'react-bulma-components'

export default function SearchBar() {
  const [query, setQuery] = useState("")

  const Search = (e) => {
    if (e.key === 'Enter') {
      props.fetchSearch(query)
      setQuery("")
    }
  }

  return (
    <>
      <Form.Field onKeyDown={Search}>
        <Form.Control iconRight>
          <Form.Input
            placeholder='Álbums, artists, songs...'
            value={query}
            onChange={e => setQuery(e.target.value)}
          />
        </Form.Control>
      </Form.Field>
    </>
  )
}