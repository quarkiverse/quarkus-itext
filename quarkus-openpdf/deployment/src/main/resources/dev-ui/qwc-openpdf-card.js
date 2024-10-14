import { pages } from 'build-time-data';
import { LitElement, css, html } from 'lit';
import 'qwc/qwc-extension-link.js';

const NAME = "OpenPDF";
export class QwcOpenPDFCard extends LitElement {

  static styles = css`
      .identity {
        display: flex;
        justify-content: flex-start;
      }

      .description {
        padding-bottom: 10px;
      }

      .logo {
        padding-bottom: 10px;
        margin-right: 5px;
      }

      .card-content {
        color: var(--lumo-contrast-90pct);
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        padding: 2px 2px;
        height: 100%;
      }

      .card-content slot {
        display: flex;
        flex-flow: column wrap;
        padding-top: 5px;
      }
    `;

  static properties = {
    description: { type: String }
  };

  constructor() {
    super();
  }

  connectedCallback() {
    super.connectedCallback();
  }

  render() {
    return html`<div class="card-content" slot="content">
            <div class="identity">
                <div class="logo">
                    <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNzUuMzIwMTI5bW0iIGhlaWdodD0iOTIuNjA0MTY0bW0iIHZpZXdCb3g9IjAgMCA3NS4zMjAxMjkgOTIuNjA0MTY0Ij4KICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg1My41NDgwNTcgLTE4My45NzUyNzYpIHNjYWxlKDEuNDg0MykiPgogICAgPHBhdGggZmlsbD0iI2ZmMjExNiIgZD0iTS0yOS42MzI4MTIgMTIzLjk0NzI3Yy0zLjU1MTk2NyAwLTYuNDQzMzYgMi44OTM0Ny02LjQ0MzM2IDYuNDQ1MzF2NDkuNDk4MDRjMCAzLjU1MTg1IDIuODkxMzkzIDYuNDQ1MzIgNi40NDMzNiA2LjQ0NTMySDguMjE2Nzk2OWMzLjU1MTk2NjEgMCA2LjQ0MzM1OTEtMi44OTMzNSA2LjQ0MzM1OTEtNi40NDUzMnYtNDAuNzAxMTdzLjEwMTM1My0xLjE5MTgxLS40MTYwMTUtMi4zNTE1NmMtLjQ4NDk2OS0xLjA4NzExLTEuMjc1MzkxLTEuODQzNzUtMS4yNzUzOTEtMS44NDM3NWExLjA1ODQzOTEgMS4wNTg0MzkxIDAgMCAwLS4wMDU5LS4wMDhsLTkuMzkwNjI1NC05LjIxMDk0YTEuMDU4NDM5MSAxLjA1ODQzOTEgMCAwIDAtLjAxNTYyNS0uMDE1NnMtLjgwMTczOTItLjc2MzQ0LTEuOTkwMjM0NC0xLjI3MzQ0Yy0xLjM5OTM5NTUyLS42MDA1LTIuODQxNzk2OC0uNTM3MTEtMi44NDE3OTY4LS41MzcxMWwuMDIxNDg0LS4wMDJ6IiBjb2xvcj0iIzAwMCIgZm9udC1mYW1pbHk9InNhbnMtc2VyaWYiIG92ZXJmbG93PSJ2aXNpYmxlIiBwYWludC1vcmRlcj0ibWFya2VycyBmaWxsIHN0cm9rZSIgc3R5bGU9ImxpbmUtaGVpZ2h0Om5vcm1hbDtmb250LXZhcmlhbnQtbGlnYXR1cmVzOm5vcm1hbDtmb250LXZhcmlhbnQtcG9zaXRpb246bm9ybWFsO2ZvbnQtdmFyaWFudC1jYXBzOm5vcm1hbDtmb250LXZhcmlhbnQtbnVtZXJpYzpub3JtYWw7Zm9udC12YXJpYW50LWFsdGVybmF0ZXM6bm9ybWFsO2ZvbnQtZmVhdHVyZS1zZXR0aW5nczpub3JtYWw7dGV4dC1pbmRlbnQ6MDt0ZXh0LWFsaWduOnN0YXJ0O3RleHQtZGVjb3JhdGlvbi1saW5lOm5vbmU7dGV4dC1kZWNvcmF0aW9uLXN0eWxlOnNvbGlkO3RleHQtZGVjb3JhdGlvbi1jb2xvcjojMDAwMDAwO3RleHQtdHJhbnNmb3JtOm5vbmU7dGV4dC1vcmllbnRhdGlvbjptaXhlZDt3aGl0ZS1zcGFjZTpub3JtYWw7c2hhcGUtcGFkZGluZzowO2lzb2xhdGlvbjphdXRvO21peC1ibGVuZC1tb2RlOm5vcm1hbDtzb2xpZC1jb2xvcjojMDAwMDAwO3NvbGlkLW9wYWNpdHk6MSIvPgogICAgPHBhdGggZmlsbD0iI2Y1ZjVmNSIgZD0iTS0yOS42MzI4MTIgMTI2LjA2NDQ1aDI4LjM3ODkwNThhMS4wNTg0MzkxIDEuMDU4NDM5MSAwIDAgMCAuMDIxNDg0IDBzMS4xMzQ4MDQ0OC4wMTEgMS45NjQ4NDM3OC4zNjcxOWMuNzk4ODk3NzIuMzQyODIgMS4zNjUzNjk4Mi44NjE3NiAxLjM2OTE0MDYyLjg2NTI0LjAwMDAxMjUuMDAwMDEuMDAzOTEuMDA0LjAwMzkxLjAwNGw5LjM2NzE4NjggOS4xODk0NXMuNTY0MzU0LjU5NTgyLjgzNzg5MSAxLjIwODk5Yy4yMjA3NzkuNDk0OTEuMjM0Mzc1IDEuNDAwMzkuMjM0Mzc1IDEuNDAwMzlhMS4wNTg0MzkxIDEuMDU4NDM5MSAwIDAgMC0uMDAyLjA0NDl2NDAuNzQ2MDljMCAyLjQxNTkyLTEuOTEwMjU4IDQuMzI4MTMtNC4zMjYxNzE3IDQuMzI4MTNILTI5LjYzMjgxMmMtMi40MTU5MTQgMC00LjMyNjE3Mi0xLjkxMjA5LTQuMzI2MTcyLTQuMzI4MTN2LTQ5LjQ5ODA0YzAtMi40MTYwMyAxLjkxMDI1OC00LjMyODEzIDQuMzI2MTcyLTQuMzI4MTN6IiBjb2xvcj0iIzAwMCIgZm9udC1mYW1pbHk9InNhbnMtc2VyaWYiIG92ZXJmbG93PSJ2aXNpYmxlIiBwYWludC1vcmRlcj0ibWFya2VycyBmaWxsIHN0cm9rZSIgc3R5bGU9ImxpbmUtaGVpZ2h0Om5vcm1hbDtmb250LXZhcmlhbnQtbGlnYXR1cmVzOm5vcm1hbDtmb250LXZhcmlhbnQtcG9zaXRpb246bm9ybWFsO2ZvbnQtdmFyaWFudC1jYXBzOm5vcm1hbDtmb250LXZhcmlhbnQtbnVtZXJpYzpub3JtYWw7Zm9udC12YXJpYW50LWFsdGVybmF0ZXM6bm9ybWFsO2ZvbnQtZmVhdHVyZS1zZXR0aW5nczpub3JtYWw7dGV4dC1pbmRlbnQ6MDt0ZXh0LWFsaWduOnN0YXJ0O3RleHQtZGVjb3JhdGlvbi1saW5lOm5vbmU7dGV4dC1kZWNvcmF0aW9uLXN0eWxlOnNvbGlkO3RleHQtZGVjb3JhdGlvbi1jb2xvcjojMDAwMDAwO3RleHQtdHJhbnNmb3JtOm5vbmU7dGV4dC1vcmllbnRhdGlvbjptaXhlZDt3aGl0ZS1zcGFjZTpub3JtYWw7c2hhcGUtcGFkZGluZzowO2lzb2xhdGlvbjphdXRvO21peC1ibGVuZC1tb2RlOm5vcm1hbDtzb2xpZC1jb2xvcjojMDAwMDAwO3NvbGlkLW9wYWNpdHk6MSIvPgogICAgPHBhdGggZmlsbD0iI2ZmMjExNiIgZD0iTS0yMy40MDc2NiAxNjEuMDkyOTljLTEuNDU2NjktMS40NTY2OS4xMTkzNC0zLjQ1ODM5IDQuMzk2NDgtNS41ODM5N2wyLjY5MTI0LTEuMzM3NDMgMS4wNDg0NS0yLjI5Mzk5Yy41NzY2NS0xLjI2MTY5IDEuNDM3MjktMy4zMjAzNiAxLjkxMjU0LTQuNTc0OGwuODY0MS0yLjI4MDgyLS41OTU0Ni0xLjY4NzkzYy0uNzMyMTctMi4wNzU0Ny0uOTkzMjYtNS4xOTQzOC0uNTI4NzItNi4zMTU4OC42MjkyMy0xLjUxOTA5IDIuNjkwMjktMS4zNjMyMyAzLjUwNjI2LjI2NTE1LjYzNzI3IDEuMjcxNzYuNTcyMTIgMy41NzQ4OC0uMTgzMjkgNi40Nzk0NmwtLjYxOTMgMi4zODEyNS41NDU1LjkyNjA0Yy4zMDAwMy41MDkzMiAxLjE3NjQgMS43MTg2NyAxLjk0NzUgMi42ODc0M2wxLjQ0OTI0IDEuODAyNzIgMS44MDMzNzI4LS4yMzUzM2M1LjcyOTAwMzk5LS43NDc1OCA3LjY5MTI0NzIuNTIzIDcuNjkxMjQ3MiAyLjM0NDc2IDAgMi4yOTkyMS00LjQ5ODQ5MTQgMi40ODg5OS04LjI3NjA4NjUtLjE2NDIzLS44NDk5NjY2LS41OTY5OC0xLjQzMzY2MDUtMS4xOTAwMS0xLjQzMzY2MDUtMS4xOTAwMXMtMi4zNjY1MzI2LjQ4MTc4LTMuNTMxNzA0Ljc5NTgzYy0xLjIwMjcwNy4zMjQxNy0xLjgwMjc0LjUyNzE5LTMuNTY0NTA5IDEuMTIxODYgMCAwLS42MTgxNC44OTc2Ny0xLjAyMDk0IDEuNTUwMjYtMS40OTg1OCAyLjQyNzktMy4yNDgzMyA0LjQzOTk4LTQuNDk3OTMgNS4xNzIzLTEuMzk5MS44MTk5My0yLjg2NTg0Ljg3NTgyLTMuNjA0MzMuMTM3MzN6bTIuMjg2MDUtLjgxNjY4Yy44MTg4My0uNTA2MDcgMi40NzYxNi0yLjQ2NjI1IDMuNjIzNDEtNC4yODU1M2wuNDY0NDktLjczNjU4LTIuMTE0OTcgMS4wNjMzOWMtMy4yNjY1NSAxLjY0MjM5LTQuNzYwOTMgMy4xOTAzMy0zLjk4Mzg2IDQuMTI2NjQuNDM2NTMuNTI1OTguOTU4NzQuNDgyMzcgMi4wMTA5My0uMTY3OTJ6bTIxLjIxODA5LTUuOTU1NzhjLjgwMDg5LS41NjA5Ny42ODQ2My0xLjY5MTQyLS4yMjA4Mi0yLjE0NzItLjcwNDY2LS4zNTQ3MS0xLjI3MjYwNzQtLjQyNzU5LTMuMTAzMTU3NC0uNDAwNTctMS4xMjQ5LjA3NjctMi45MzM3NjQ3LjMwMzQtMy4yNDAzMzQ3LjM3MjM3IDAgMCAuOTkzNzE2LjY4Njc4IDEuNDM0ODk2LjkzOTIyLjU4NzMxLjMzNTQ0IDIuMDE0NTE2MS45NTgxMSAzLjA1NjUxNjEgMS4yNzcwNiAxLjAyNzg1LjMxNDYxIDEuNjIyNC4yODE0NCAyLjA3MjktLjA0MDl6bS04LjUzMTUyLTMuNTQ1OTRjLS40ODQ3LS41MDk1Mi0xLjMwODg5LTEuNTcyOTYtMS44MzE1Mi0yLjM2MzItLjY4MzUzLS44OTY0My0xLjAyNjI5LTEuNTI4ODctMS4wMjYyOS0xLjUyODg3cy0uNDk5NiAxLjYwNjk0LS45MDk0OCAyLjU3Mzk0bC0xLjI3ODc2IDMuMTYwNzYtLjM3MDc1LjcxNjk1czEuOTcxMDQzLS42NDYyNyAyLjk3Mzg5LS45MDgyMmMxLjA2MjE2NjgtLjI3NzQ0IDMuMjE3ODctLjcwMTM0IDMuMjE3ODctLjcwMTM0em0tMi43NDkzOC0xMS4wMjU3M2MuMTIzNjMtMS4wMzc1LjE3NjEtMi4wNzM0Ni0uMTU3MjQtMi41OTU4Ny0uOTI0Ni0xLjAxMDc3LTIuMDQwNTctLjE2Nzg3LTEuODUxNTQgMi4yMzUxNy4wNjM2LjgwODQuMjY0NDMgMi4xOTAzMy41MzI5MiAzLjA0MjA5bC40ODgxNyAxLjU0ODYzLjM0MzU4LTEuMTY2MzhjLjE4ODk3LS42NDE1MS40Nzg4Mi0yLjAyMDE1LjY0NDExLTMuMDYzNjR6Ii8+CiAgICA8cGF0aCBmaWxsPSIjMmMyYzJjIiBkPSJNLTIwLjkzMDQyMyAxNjcuODM4NjJoMi4zNjQ5ODZxMS4xMzM1MTQgMCAxLjg0MDIxMy4yMTY5LjcwNjY5OC4yMDk5MSAxLjE4OTQ4OS45NDQ2LjQ4Mjc5NS43Mjc2OS40ODI3OTUgMS43NTYyNSAwIC45NDQ1OS0uMzkxODMyIDEuNjIzMy0uMzkxODMzLjY3ODcxLTEuMDU2NTQ4Ljk3OTU4LS42NTc3Mi4zMDA4Ny0yLjAyOTEzLjMwMDg3aC0uODE4NjUxdjMuNzI5NDFoLTEuNTgxMzIyem0xLjU4MTMyMiAxLjIyNDQ3djMuMzMwNThoLjc4MzY2NHExLjA0OTU1MiAwIDEuNDQ4MzgtLjM5MTg0LjQwNTgyNi0uMzkxODMuNDA1ODI2LTEuMjczNDUgMC0uNjU3NzItLjI2NTg4Ny0xLjA2MzU1LS4yNjU4ODQtLjQxMjgyLS41ODc3NDctLjUwMzc4LS4zMTQ4NjYtLjA5OC0xLjAwMDU3Mi0uMDk4em01LjUwNjY0LTEuMjI0NDdoMi4xNDgwODJxMS41NjAzMzMgMCAyLjQ5MDkzMTguNTUyNzYuOTM3NTk5My41NTI3NiAxLjQxMzM5NzMgMS42NDQzLjQ4Mjc5MSAxLjA5MTUzLjQ4Mjc5MSAyLjQyMDk2IDAgMS4zOTk0LS40MzM4MTUxIDIuNDk3OTMtLjQyNjgxNDkgMS4wOTE1My0xLjMxNTQzNDggMS43NjMyNC0uODgxNjIzMy42NzE3Mi0yLjUxODkyMTIuNjcxNzJoLTIuMjY3MDMxem0xLjU4MTMyNiAxLjI2NjQ1djcuMDE4aC42NTc3MTVxMS4zNzg0MTEgMCAyLjAwMTE0NC0uOTUxNi42MjI3MzI5LS45NTg1OC42MjI3MzI5LTIuNTUzOSAwLTMuNTEyNS0yLjYyMzg3NjktMy41MTI1em02LjQ3MjIyNTQtMS4yNjY0NWg1LjMwMzcyOTQxdjEuMjY2NDVILTQuMjA3NTg0MnYyLjg1NDc4aDIuOTgwNzIyNXYxLjI2NjQ2aC0yLjk4MDcyMjV2NC4xNjMyMmgtMS41ODEzMjU0eiIgZm9udC1mYW1pbHk9IkZyYW5rbGluIEdvdGhpYyBNZWRpdW0gQ29uZCIgbGV0dGVyLXNwYWNpbmc9IjAiIHN0eWxlPSJsaW5lLWhlaWdodDoxMjUlOy1pbmtzY2FwZS1mb250LXNwZWNpZmljYXRpb246J0ZyYW5rbGluIEdvdGhpYyBNZWRpdW0gQ29uZCciIHdvcmQtc3BhY2luZz0iNC4yNjAwMDAyMyIvPgogIDwvZz4KPC9zdmc+"
                                       alt="${NAME}" 
                                       title="${NAME}"
                                       width="32" 
                                       height="32">
                </div>
                <div class="description">${this.description}</div>
            </div>
            ${this._renderCardLinks()}
        </div>
        `;
  }

  _renderCardLinks() {
    return html`${pages.map(page => html`
                            <qwc-extension-link slot="link"
                                extensionName="${NAME}"
                                iconName="${page.icon}"
                                displayName="${page.title}"
                                staticLabel="${page.staticLabel}"
                                dynamicLabel="${page.dynamicLabel}"
                                streamingLabel="${page.streamingLabel}"
                                path="${page.id}"
                                ?embed=${page.embed}
                                externalUrl="${page.metadata.externalUrl}"
                                webcomponent="${page.componentLink}" >
                            </qwc-extension-link>
                        `)}`;
  }

}
customElements.define('qwc-openpdf-card', QwcOpenPDFCard);