const apiClientes = '/api/clientes';
async function listarClientes() {
  const res = await fetch(apiClientes);
  const data = await res.json();
  const tbody = document.querySelector('#tblClientes tbody');
  if (!tbody) return;
  tbody.innerHTML = '';
  data.forEach(c => {
    const tr = document.createElement('tr');
    tr.innerHTML = `<td>${c.id}</td><td>${c.nome}</td><td>${c.cpf||''}</td><td>${c.telefone||''}</td><td>${c.email||''}</td><td><button onclick="excluir(${c.id})">Excluir</button></td>`;
    tbody.appendChild(tr);
  });
}
async function excluir(id){ if(!confirm('Excluir cliente?')) return; await fetch(apiClientes+'/'+id,{method:'DELETE'}); listarClientes(); }
function validar(c){ if(!c.nome || c.nome.trim().length<3){ alert('Nome inválido'); return false;} return true; }
async function salvarCliente(e){ e.preventDefault(); const fd=new FormData(e.target); const obj=Object.fromEntries(fd.entries()); if(!validar(obj)) return; await fetch(apiClientes,{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(obj)}); window.location='/clientes-listar.html'; }
document.addEventListener('DOMContentLoaded',()=>{ if(document.querySelector('#tblClientes')) listarClientes(); const f=document.querySelector('#frmCliente'); if(f) f.addEventListener('submit', salvarCliente); });
